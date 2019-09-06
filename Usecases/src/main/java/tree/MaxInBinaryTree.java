package tree;

public class MaxInBinaryTree {

    public static int maxInBinary(TreeNode.Node root) {
        int max = Integer.MIN_VALUE;
        int val = 0;
        if (root != null) {
            val = root.data;
            int left = maxInBinary(root.left);
            int right = maxInBinary(root.right);
            if (left < right) {
                max = right;
            } else {
                max = left;
            }
            if (max < val) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int[] arr = {4, 22, 5, 1, 3, 6,9,12};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(maxInBinary(t2.root));
    }
}
