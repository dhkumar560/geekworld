package tree;

public class HeightOfBinaryTree {
    public static int heightOfBinaryTree(TreeNode.Node root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right));
    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(heightOfBinaryTree(t2.root));
        t2.inOrder(t2.root);
    }
}
