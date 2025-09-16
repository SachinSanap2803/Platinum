public class pigeonholePrinciple {
    public static void main(String[] args) {
        int k = 13, n = 12;

        int maxObj = maxObject(k, n);
        System.out.println("container contains at most " + maxObj + " object");
    }

    public static int maxObject(int k, int n) {
        if(n == 0) {
            return 0;
        }

        int maxObj = k/n + 1;
        // int maxObj = (k+n-1)/n;
        return maxObj;
    }
}