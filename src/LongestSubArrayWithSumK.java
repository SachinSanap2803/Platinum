import java.util.HashMap;

public class LongestSubArrayWithSumK {

//    public void longestSubarray(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        int maxLen = 0;
//
//        for(int i=0; i<nums.length; i++) {
//            sum += nums[i];
//            if(sum == k) {
//                maxLen = Math.max(maxLen, i+1);
//            }
//            int rem = sum - k;
//            if(map.containsKey(rem)) {
//                int len = i - map.get(rem);
//                maxLen = Math.max(maxLen, len);
//            }
//
//            if(!map.containsKey(sum)) {
//                map.put(sum, i);
//            }
//        }
//
//        System.out.println(maxLen);
//    }



    public static void longestSubarray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = 0;
        int n = nums.length;

        while(right < n) {
            sum += nums[right];

            while(left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if(sum == k) {
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;
            if(right < n) {
                sum += nums[right];
            }
        }

        System.out.println(maxLen);
    }
}