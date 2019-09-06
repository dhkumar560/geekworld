package string;

public class ReverseStringWithXOR {

    public static String reverse(String s){
        char strArr[] = s.toCharArray();
        int start = 0,end = strArr.length-1;
        while(start < end){
            strArr[start] = (char)(strArr[start] ^ strArr[end]);
            strArr[end] = (char)(strArr[end] ^ strArr[start]);
            strArr[start] = (char)(strArr[start] ^ strArr[end]);
            ++start;
            --end;
        }
        return new String(strArr);
    }

    public static void main(String[] args) {
        String str = "YAJNANAHD";
        System.out.println(reverse(str));
    }
}
