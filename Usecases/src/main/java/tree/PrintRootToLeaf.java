package tree;

import java.util.Stack;

public class PrintRootToLeaf {
    static Stack<Integer>  stack = new Stack<>();
    static int total = 0;
    public static void printRootToLeaf(TreeNode.Node root){
        if(root==null){
            return;
        }
        stack.push(root.data);
        printRootToLeaf(root.left);
        if(root.left == null && root.right==null) {
                System.out.println(stack);
        }
        printRootToLeaf(root.right);
        stack.pop();
    }

    public static void sumPrintRootToLeaf(TreeNode.Node root){
        if(root==null){
            return;
        }
        stack.push(root.data);
        total+=root.data;
        if(total == 9){
            System.out.println(stack);
        }
        sumPrintRootToLeaf(root.left);
        sumPrintRootToLeaf(root.right);
        total-=root.data;
        stack.pop();
    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
//        printRootToLeaf(t2.root);
        sumPrintRootToLeaf(t2.root);
        t2.inOrder(t2.root);
    }
}
