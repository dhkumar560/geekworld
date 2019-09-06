package tree;

public class PrintBoundaryElement {

    public static void printLeftBoundary(TreeNode.Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        System.out.print(root.data + " ");
        if (root.left == null) {
            printLeftBoundary(root.right);
        } else
            printLeftBoundary(root.left);
    }

    public static void printRightBoundary(TreeNode.Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        System.out.print(root.data + " ");
        if (root.right == null) {
            printRightBoundary(root.left);
        } else {
            printRightBoundary(root.right);
        }

    }

    public static void printLeaves(TreeNode.Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int[] arr = {4, 2, 5, 1, 3, 6, 7, 8, 9};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(t2.root.data);
        printLeftBoundary(t2.root.left);
        printLeaves(t2.root);
        printRightBoundary(t2.root.right);
    }
}
