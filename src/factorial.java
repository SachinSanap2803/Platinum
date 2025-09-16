public class factorial {
    public static void main(String[] args) {
        int n = 6;
        int result = fact(n);
        System.out.println("Factorial of " + n + " is " + result);
    }

    static int fact(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return n * fact(n-1);
    }
}