import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int[] profit = {120, 100, 60};
        int[] weight = {17, 13, 8};
        int sack = 20;
        double ans = 0;

        double maxProfit =  knapsack(sack, profit, weight);
        System.out.println("Max Profit : " + maxProfit);
    }

    public static double knapsack(int sack, int[] profit, int[] weight) {
        int n = profit.length;
        double res = 0;
        TreeMap<Double, List<Integer>> tm = new TreeMap<>();

        for(int i=0; i<n; i++) {
            List<Integer> li = new ArrayList<>();
            li.add(profit[i]);
            li.add(weight[i]);

            double p = profit[i];
            double w = weight[i];

            tm.put(p/w, li);
        }

        for(Map.Entry<Double, List<Integer>> entry: tm.descendingMap().entrySet()) {
            if(entry.getValue().get(1) <= sack) {
                res += entry.getValue().get(0);
                sack -= entry.getValue().get(1);
            } else {
                res = res + (sack * (entry.getValue().get(0)/ entry.getValue().get(1)));
                break;
            }
        }

        return res;
    }
}