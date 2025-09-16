import java.util.HashMap;

public class longestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            if(map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }

            map.put(ch, end);

            maxLen = Math.max(maxLen, end-start+1);
        }

        System.out.println(maxLen);
    }
}