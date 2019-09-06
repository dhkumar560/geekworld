package bitoperator;

public class MultiplyBy7 {

    public static int multiplyBy7(int num){
        return ((num<<3) - num);
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(multiplyBy7(n));
    }
}
