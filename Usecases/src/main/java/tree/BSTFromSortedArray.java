package tree;

import sun.reflect.generics.tree.Tree;

public class BSTFromSortedArray {
    public static TreeNode.Node bstFromSortedArray(int[] ar,int low, int high){
        if(low>high) {
            return null;
        }
        int mid = low + (high-low)/2;
        TreeNode.Node node = new TreeNode.Node(ar[mid]);
        node.left = bstFromSortedArray(ar,low,mid-1);
        node.right = bstFromSortedArray(ar,mid+1,high);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int arr[] = {-10,-3,0,5,9};
        TreeNode.Node n =bstFromSortedArray(arr,0,arr.length-1);
        t2.inOrder(n);

    }
}
