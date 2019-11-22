package bitoperator;

public class BinaryIsPalindrome {

    public static boolean isPalindrome(int n)
    {
        int rev = 0;
        int k = n;
        while (k > 0)
        {
            rev = (rev << 1) | (k & 1);
            k = k >> 1;		// drop last bit
        }
        return n == rev;
    }

    public static void main(String[] args) {
        int n = 27;

        if (isPalindrome(n)) {
            System.out.println(n + " is Palindrome");
        }
        else {
            System.out.println(n + " is not a Palindrome");
        }
    }
}
