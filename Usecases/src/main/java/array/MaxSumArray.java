package array;

public class MaxSumArray {
    public static int maxSum(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int s = 0, start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            max_ending_here = max_ending_here + arr[i];
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
                System.out.println("sum upto" + max_ending_here + "::" + i);
            } else if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
        }
        System.out.println(start + "::" + end);
        return max_so_far;

    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3, -5, 6, 9};
        System.out.println(maxSum(arr));
    }
}
