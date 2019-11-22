package bitoperator;

public class CountBitsToBeFlipped {

    public static int calculate(int x , int y){
        int r = x ^ y;
        System.out.println("Bit count is ::"+Integer.bitCount(r));
        int count = 0;
        while (r > 0)
        {
            // this will turn off rightmost bit of a number
            r &= (r - 1) ;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 10;
        int y =20;
        System.out.println("Number of bit needs to be flipped to convert " + x + " to " + y + " are: " + calculate(x,y));
    }
}
