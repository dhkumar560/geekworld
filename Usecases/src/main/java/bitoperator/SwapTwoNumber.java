package bitoperator;

public class SwapTwoNumber {

    public static void main(String[] args) {
        int x = 42;
        int y = 8;
        int r = x^y;
        x = x^r;
        y = y^r;
        System.out.println("The value of x:"+x+" and Y:"+y);
    }
}
