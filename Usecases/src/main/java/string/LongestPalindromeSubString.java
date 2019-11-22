package string;

public class LongestPalindromeSubString {
    public static String longestPalindrome(String str) {
        int len = str.length();
        if (len < 2)
            return str;
        boolean[][] isPalindrome = new boolean[len][len];
        int right = 0, left = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalidrome = isPalindrome[i + 1][j- 1] || j - i <= 2;
                if (str.charAt(i) == str.charAt(j) && isInnerPalidrome) {
                    isPalindrome[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }

        }
        return str.substring(left, right + 1);
    }


    public static void main(String[] args) {
        String str = "abcdcbyteretybcd";
        System.out.println(longestPalindrome(str));
    }
}
