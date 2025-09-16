import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

public class isSumZero {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 4, 6, -3, 3};
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(i > 0 && arr[i] == arr[i-1]) {
                continue;
            }

            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if(sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();

                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(arr[k]);

                    ans.add(list);
                    j++;
                    k--;

                    while(j < k && arr[j] == arr[j-1]) {
                        j++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}