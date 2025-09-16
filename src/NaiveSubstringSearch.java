import java.util.ArrayList;
import java.util.List;

public class NaiveSubstringSearch {
    public static void main(String[] args) {
        String str = "AAAAA";
        String pattern = "AA";

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<=str.length()-pattern.length(); i++) {
            int temp = i;
            int j = 0;
            for(j=0; j<pattern.length(); j++) {
                if(str.charAt(temp) == pattern.charAt(j)) {
                    temp++;
                } else {
                    break;
                }
            }
            if(j == pattern.length()) {
                list.add(i);
            }
        }

        System.out.println(list);
    }
}