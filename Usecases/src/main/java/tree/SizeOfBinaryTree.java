package tree;

public class SizeOfBinaryTree {
    public static int sizeOfBinaryTree(TreeNode.Node root){
        if(root == null){
            return 0;
        }
        return 1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right);
    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,4,6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(sizeOfBinaryTree(t2.root));
        t2.inOrder(t2.root);
    }
}
