import java.util.HashMap;

public class countDistinctEle {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        int w = 4;

        countDistinct(arr, w);
    }

    public static void countDistinct(int[] arr, int w) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int[] ans = new int[n-w+1];

        for(int i=0; i<w; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        ans[k] = map.size();
        k++;

        for(int i=w; i<n; i++) {
            if (map.getOrDefault(arr[i - w], 0) == 1) {
                map.remove(arr[i - w]);
            } else {
                map.put(arr[i-w], map.get(arr[i-w])-1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            ans[k] = map.size();
            k++;
        }

        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + "  ");
        }
    }
}