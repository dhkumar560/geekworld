package tree;

public class PrintNodeHavingKLeaves {

    public static int printNodeHavingKLeaves(TreeNode.Node root, int k){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        int lCount = printNodeHavingKLeaves(root.left,k);
        int rCount = printNodeHavingKLeaves(root.right,k);
        int tCount = lCount + rCount;
        if(tCount == k){
            System.out.println(root.data);
        }
        return tCount;
    }




    public static void main(String[] args) {

        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,6,7,9,12};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        printNodeHavingKLeaves(t2.root,3);
    }


}
