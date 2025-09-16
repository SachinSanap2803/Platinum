import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 1};
        int target = 29;
        Arrays.sort(arr);

        for(int i = arr.length-1; i>=0; i--) {
            int coin = arr[i];
            if(coin <= target) {
                int count = target / coin;
                target %= coin;
                System.out.println(coin + "*" + count);
            }
            if(target == 0) {
                break;
            }
        }
    }
}