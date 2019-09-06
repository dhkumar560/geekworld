package tree;

public class LcaBinaryTree {
    public static TreeNode.Node lcaBinaryTree(TreeNode.Node root,int a, int b){
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b)
            return root;
        TreeNode.Node left = lcaBinaryTree(root.left,a,b);
        TreeNode.Node right = lcaBinaryTree(root.right,a,b);
        if(left!=null && right !=null){
            return root;
        }
        if(left == null && right == null) return null;
        return left!=null?left:right;
    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(lcaBinaryTree(t2.root,6,3).data);
    }
}
