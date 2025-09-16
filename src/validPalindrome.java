public class validPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panam";
        boolean flag = true;

        if(str.length() == 1) {
            System.out.println(flag);
            return;
        }

        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch - 'A' + 'a');
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
        }

        int start = 0;
        int end = sb.length()-1;

        while(start < end) {
            if(sb.charAt(start) != sb.charAt(end)) {
                flag = false;
                System.out.println(flag);
                return;
            }
            start++;
            end--;
        }

        System.out.println(flag);
    }
}