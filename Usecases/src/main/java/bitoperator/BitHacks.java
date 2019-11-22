package bitoperator;

public class BitHacks {
    public static void main(String[] args) {
        //     The expression (n & 1) will return value 1 or 0 depending upon n is odd or even
        int n = 5;

        if ((n & 1) == 1) {
            System.out.println(n + " is odd");
        } else {
            System.out.println(n + " is even");
        }

        // add 1 to a given Integer
//        the expression -~x will add 1 to given integer. To get the negative number invert the bit and add 1
//        to them(negative number stored in 2's complement form)

        int x = 4;
        System.out.println(x + " + " + 1 + " is " + -~x);

        x = -5;
        System.out.println(x + " + " + 1 + " is " + -~x);

        x = 0;
        System.out.println(x + " + " + 1 + " is " + -~x);
    }

    // Function to turn off k'th bit in n
    public static int turnOffKthBit(int n, int k) {
        return n & ~(1 << (k - 1));
    }

    // Function to turn on k'th bit in n
    public static int turnOnKthBit(int n, int k)
    {
        return n | (1 << (k - 1));
    }

}
