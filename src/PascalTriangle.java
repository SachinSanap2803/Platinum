// 1] Given row and col no., find  the element at that place.

//public class PascalTriangle {
//    public static void main(String[] args) {
//        int row = 5;
//        int col = 4;
//
//        System.out.println(calNcR(row, col));
//    }
//
//    public static int calNcR(int n, int r) {
//        int res = 1;
//        for(int i=0; i<r; i++) {
//            res = res * (n-i);
//            res = res / (i+1);
//        }
//
//        return res;
//    }
//}



// 2] Given N, print Nth row.

//public class PascalTriangle {
//    public static void main(String[] args) {
//        int N = 4;
//
//        int res = 1;
//        System.out.print(res + " ");
//        for(int c = 1; c < N; c++) {
//            System.out.print(calNcR(N-1, c) + " ");
//        }
//    }
//
//    public static int calNcR(int n, int r) {
//        int res = 1;
//        for(int i=0; i<r; i++) {
//            res = res * (n-i);
//            res = res / (i+1);
//        }
//
//        return res;
//    }
//}


//public class PascalTriangle {
//    public static void main(String[] args) {
//        int N = 6;
//
//        int res = 1;
//        System.out.print(res + "  ");
//
//        for(int i=1; i<N; i++) {
//            res = res * (N-i);
//            res = res / i;
//            System.out.print(res + "  ");
//        }
//    }
//}




// 3] Given N, print entire pascal's triangle till N

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int N = 5;
        List<List<Integer>> ans = new ArrayList<>(N);

        for(int i=1; i<=N; i++) {
            List<Integer> temp = new ArrayList<>();
            int res = 1;
            temp.add((res));

            for(int j=1; j<i; j++) {
                res = res * (i-j);
                res = res / j;
                temp.add(res);
            }

            ans.add((temp));
        }

        System.out.println(ans);
    }
}