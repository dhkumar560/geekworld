package dynamicprogramming;

public class LongestCommonSubstring {

    public static int longestCommonSubstring(char[] s1, char[] s2) {
        int[][] T = new int[s1.length + 1][s2.length + 1];
        int max = 0;
        int index = -1;
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    max = Math.max(max, T[i][j]);
                    index = i;
                }
            }
        }
        System.out.println(index);
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char[] str1 = "abcdef".toCharArray();
        char[] str2 = "zcdemf".toCharArray();
        System.out.println(longestCommonSubstring(str1, str2));
    }
}
