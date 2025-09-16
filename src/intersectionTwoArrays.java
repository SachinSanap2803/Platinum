import java.util.HashSet;

public class intersectionTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2, 1};

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int num : arr1) {
            set1.add((num));
        }

        for(int num : arr2) {
            if(set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] ans = new int[set2.size()];
        int i=0;
        for(int num : set2) {
            ans[i++] = num;
        }

        System.out.print("Common elements in both the arrays are : ");
        for(int j=0; j<ans.length; j++) {
            System.out.print(ans[j] + "  ");
        }
    }
}