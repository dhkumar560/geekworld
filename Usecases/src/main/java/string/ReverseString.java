package string;

public class ReverseString {

    public static String reverse(String str) {
        char temp;
        char[] strArr = str.toCharArray();
        for (int start = 0, end = str.length()-1; start < end; start++, end--) {
            temp = strArr[start];
            strArr[start] = str.charAt(end);
            strArr[end] = temp;
        }
        return new String(strArr);
    }


    public static void main(String[] args) {
        String s = "YAJNANAHD";
        System.out.println(reverse(s));
    }
}
