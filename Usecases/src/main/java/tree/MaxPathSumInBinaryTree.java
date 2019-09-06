package tree;

public class MaxPathSumInBinaryTree {
    public static int result = Integer.MIN_VALUE;

    public static int maxPath(TreeNode.Node root) {
        if (root == null) {
            return 0;
        }
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        int maxlr = Math.max(l, r);
        int maxSingle = Math.max(maxlr, maxlr + root.data);
        int maxAll = Math.max(maxSingle, l + r + root.data);
        result = Math.max(maxAll, result);
        return maxSingle;
    }


    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int[] arr = {-10, 2, 5, -1, 6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        maxPath(t2.root);
        System.out.println(result);
        t2.inOrder(t2.root);

    }
}
