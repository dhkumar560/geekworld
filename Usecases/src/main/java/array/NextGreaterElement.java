package array;

import java.util.Stack;

public class NextGreaterElement {
    public static void nextGreaterElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && s.peek() < arr[i]) {
                System.out.println(s.peek() + "--------->" + arr[i]);
                s.pop();
            }
            s.push(arr[i]);
        }
        while (!s.isEmpty()) {
            int top = s.pop();
            System.out.println("Next greater element for " + top + "\t = " + null);
        }
    }

    public static void main(String[] args) {
        int[] arr = {98, 23, 54, 12, 20, 7, 27};
        nextGreaterElement(arr);
    }
}
