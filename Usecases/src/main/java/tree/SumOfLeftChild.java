package tree;

public class SumOfLeftChild {
    static int sumOfLeftLeaves = 0;

    public static int sumOfLeftChild(TreeNode.Node root, TreeNode.Node parent) {

        if (root != null) {
            sumOfLeftChild(root.left, root);
            if (root.left == null && root.right == null && parent.left == root) {
                sumOfLeftLeaves += root.data;
            }
            sumOfLeftChild(root.right, root);

        }
        return sumOfLeftLeaves;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int[] arr = {4, 2, 5, 1, 3, 6, 7, 9, 10, 11};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(sumOfLeftChild(t2.root, t2.root));
        t2.inOrder(t2.root);
    }
}
