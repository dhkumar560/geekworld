package tree;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MirrorBinaryTree {

    public static TreeNode.Node mirrorBinaryTree(TreeNode.Node root){
        if(root ==null) return root;
        TreeNode.Node left = mirrorBinaryTree(root.left);
        TreeNode.Node right = mirrorBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
        TreeNode.Node n = mirrorBinaryTree(t2.root);
        t2.inOrder(n);

        int sum = IntStream.range(0,10).filter(e->e%3==0 || e%5==0).sum();
        System.out.println(sum);
    }
}
