package tree;

import java.util.*;

public class VerticalOrderInBst {

    public static Map<Integer, ArrayList<Integer>> verticalOrderInBst(TreeNode.Node root){
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<TreeNode.Node> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(0);
        while(!q1.isEmpty()){
            TreeNode.Node n = ((LinkedList<TreeNode.Node>) q1).pop();
            int order = ((LinkedList<Integer>) q2).pop();
            ArrayList<Integer> list = map.get(order);
            if(list ==null){
                list = new ArrayList<>();
                map.put(order,list);
            }
            list.add(n.data);
            if(n.left !=null){
                q1.add(n.left);
                q2.add(order-1);
            }
            if(n.right !=null){
                q1.add(n.right);
                q2.add(order+1);
            }

        }

return map;

    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 4,2,5,1,3,6};
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        System.out.println(verticalOrderInBst(t2.root));
        t2.inOrder(t2.root);
    }
}
