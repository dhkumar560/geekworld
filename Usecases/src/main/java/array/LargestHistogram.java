package array;

import java.util.Stack;

public class LargestHistogram {

    public static int maxHistogramArea(int[] arr) {
        int maxArea = 0;
        int area = 0, top;
        int i;
        Stack<Integer> s = new Stack<>();
        for (i = 0; i < arr.length; ) {
            if (s.empty() || arr[s.peek()] <= arr[i]) {
                s.push(i++);
            } else {
                top = s.peek();
                s.pop();
                area = arr[top] * (s.empty() ? i : i - s.peek() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }

            }
        }
        while (s.empty() == false) {
            top = s.peek();
            s.pop();
            area = arr[top] * (s.empty() ? i : i - s.peek() - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxHistogramArea(arr));
    }
}
