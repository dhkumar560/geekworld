package string;

public class RemoveAdjacentPairs {
    public static String removeDuplicatePairs(String str) {
        char[] strArray = str.toCharArray();
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while ((strArray[i] == strArray[j]) && (j >= 0)) {
                i++;
                j--;
            }
            strArray[++j] = strArray[i];
        }

        return new String(strArray).substring(0,j+1);
    }


    public static void main(String[] args) {
        String str = "ABCCBCBA";
        System.out.println(removeDuplicatePairs(str));
    }
}
