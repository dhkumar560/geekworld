package tree;

public class IsBst {

    public static  boolean isBst(TreeNode.Node root,int min,int max){
        if(root == null)
            return true;
        if(root.data<=min || root.data>=max){
            return false;
        }
        return isBst(root.left,min,root.data) && isBst(root.right,root.data,max);

    }
    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(isBst(t2.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        t2.inOrder(t2.root);
    }
}
