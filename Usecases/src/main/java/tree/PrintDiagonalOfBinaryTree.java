package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintDiagonalOfBinaryTree {

    public static void printDiagonal(TreeNode.Node root){
        Queue<TreeNode.Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode.Node n = ((LinkedList<TreeNode.Node>) queue).pop();
            if(n == null){
                queue.add(null);
                n= ((LinkedList<TreeNode.Node>) queue).pop();
                if(n== null) break;
            }
            while(n!=null){
                System.out.println(n.data+ " ");
                if(n.left != null){
                    queue.add(n.left);
                }
                n=n.right;
            }
        }

    }
    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,7,9};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        printDiagonal(t2.root);
//        t2.inOrder(t2.root);
    }
}
