package dynamicprogramming;

public class CuttingRod {
    public static int rodCut(int[] price, int n)
    {
        // T[i] stores maximum profit achieved from rod of length i
        int[] T = new int[n + 1];
        // consider rod of length i
        for (int i = 1; i <= n; i++)
        {
            // divide the rod of length i into two rods of length j
            // and i-j each and take maximum
            for (int j = 1; j <= i; j++) {
                T[i] = Integer.max(T[i], price[j - 1] + T[i - j]);
                System.out.println(T[i]+"::"+T[i-j]);
            }
        }
        // T[n] stores maximum profit achieved from rod of length n
        return T[n];
    }
    // main function
    public static void main(String[] args)
    {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 5;		// rod length
        System.out.print("Profit is " + rodCut(price, n));
    }
}
