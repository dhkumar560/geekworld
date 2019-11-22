package bitoperator;

public class NumberIsPowerOf2 {
    public static void main(String[] args) {
        int x = 16;
        // it will unset rightmost bit since if number is power of 2 its rightmost bit would be 0
        int r = x & (x-1);
        System.out.println(r);
    }
}
