public class findAnagramInStr {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        findAnagram(s,p);
    }

    public static void findAnagram(String s, String p) {
        int[] res = new int[s.length()];
        int idx = 0;

        if(p.length() > s.length()) {
            return;
        }

        int[] freq = new int[26];
        for( Character ch :p.toCharArray()) {
            freq[ch-'a']++;
        }

        int left = 0, right = 0;
        int charToMatch = p.length();

        while (right < s.length()) {
            if(freq[s.charAt(right) - 'a']-- > 0) {
                charToMatch--;
            }

            if(right-left+1 == p.length()) {
                if(charToMatch == 0) {
                    res[idx] = left;
                    idx++;
                }

                if(freq[s.charAt(left) - 'a']++ >= 0) {
                    charToMatch++;
                }

                left++;
            }

            right++;
        }

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + "  ");
        }
    }
}
