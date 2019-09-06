package tree;

import java.util.HashMap;
import java.util.Map;

public class SumOfNodesInBottomView {
    static Map<Integer,Integer> map = new HashMap<>();
    public static void bottomViewBinaryTree(TreeNode.Node root,int hd){
        if(root==null) return;
            map.put(hd,root.data);
        bottomViewBinaryTree(root.left,hd-1);
        bottomViewBinaryTree(root.right,hd+1);
        }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode();
        int arr[] = { 1,2,3,4,5,6,7};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        bottomViewBinaryTree(t2.root,0);
        int sum = map.values().stream().reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
