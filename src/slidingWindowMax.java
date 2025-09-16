import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindowMax {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int n = nums.length;
        int k = 3;
        int[] arr = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            while(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k-1) {
                arr[i-k+1] = nums[dq.peekFirst()];
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}




//public class slidingWindowMax {
//    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int n = nums.length;
//        int k = 3;
//        int[] ans = new int[n-k+1];
//
//        for(int i=0; i<=n-k; i++) {
//            int max = Integer.MIN_VALUE;
//            for(int j=i; j<i+k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            ans[i] = max;
//        }
//
//        for(int i=0; i<ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
//    }
//}