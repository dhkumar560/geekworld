package tree;

public class DistanceOfTwoNodeInBinaryTree {
    public static int distanceOfTwoNodeInBinaryTree(TreeNode.Node root,int a,int b){
        if(root == null) return 0;
        if(root.data == a || root.data == b){
            return 1;
        }
        int left = distanceOfTwoNodeInBinaryTree(root.left,a,b);
        int right = distanceOfTwoNodeInBinaryTree(root.right,a,b);

        if(left>0 && right>0) return left+right;
        else{
            return left>0? ++left:++right;
        }

    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(distanceOfTwoNodeInBinaryTree(t2.root,5,6));

    }
}
