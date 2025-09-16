public class print1toN {
    public static void main(String[] args) {
        int n = 10;
        oneToN(n);
    }

    static void oneToN(int n) {
        if(n == 0) {
            return;
        }

        oneToN(n-1);
        System.out.print(n + "  ");
    }
}
