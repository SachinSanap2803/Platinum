import java.util.Arrays;

public class isAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isTrue = true;

        if(s.length() != t.length()) {
            isTrue = false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(!Arrays.equals(arr1, arr2)) {
            isTrue = false;
        }

        System.out.println(s + " and " + t + " are Anagram : " + isTrue);
    }
}