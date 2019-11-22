package string;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubString {

    public static int longestNonrepeatingSubString(String str){
        int i=0,j=0,maxLen=0;
        Set<Character> set =new HashSet<>();
        while(j<str.length()){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                j++;
                maxLen = Math.max(maxLen,j-i);
            }else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcddgfuc";
        System.out.println(longestNonrepeatingSubString(str));
    }
}
