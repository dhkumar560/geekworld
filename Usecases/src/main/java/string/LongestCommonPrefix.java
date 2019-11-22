package string;

public class LongestCommonPrefix {
    public static String longestPrefix(String[] str){
        String longestPrefix = str[0];
        for(int i=0;i<str.length;i++){
            int j =0;
            String currString = str[i];
            while(j<longestPrefix.length() && j < currString.length() && longestPrefix.charAt(j)==currString.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            longestPrefix = longestPrefix.substring(0,j);
        }
        return longestPrefix;
    }

    public static void main(String[] args) {
        String[] str = {"absrtyy","absdrty","absfrty","a3bsldkdk"};
        System.out.println(longestPrefix(str));
    }
}
