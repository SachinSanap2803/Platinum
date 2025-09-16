public class isPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        int start = 0;
        int end = str.length()-1;
        boolean istrue = true;

        while(start <= end) {
            if(str.charAt(start) != str.charAt(end)) {
                istrue = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println(istrue);
    }
}