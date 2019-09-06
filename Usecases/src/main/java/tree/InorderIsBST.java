package tree;

import java.util.Stack;

public class InorderIsBST {

    public static void main(String[] args) {
        InorderIsBST bst = new InorderIsBST();
        int[] pre2 = new int[]{40, 30, 28, 35, 36, 80, 76, 100};
        int n1 = pre2.length;
        if (bst.canRepresentBST(pre2, n1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    boolean canRepresentBST(int[] pre, int n) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre[i] < root) {
                return false;
            }
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }
}