package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializalizingAndDeserializingBinaryTree {
    static int index =0;
    public static void serialize(TreeNode.Node root, List<Integer> array){
        if(root == null){
            array.add(-1);
            return;
        }
        array.add(root.data);
        serialize(root.left,array);
        serialize(root.right,array);
    }

    public static TreeNode.Node deserialize(List<Integer> array){
        if(index == array.size() || array.get(index)== -1){
            index++;
            return null;
        }
        TreeNode.Node node = new TreeNode.Node(array.get(index));
        index++;
        node.left = deserialize(array);
        node.right = deserialize(array);
        return node;
    }

    public static void main(String args[])
    {
        TreeNode t2 = new TreeNode();
        int arr[] = { 7,2,5,4,6,3,8};
        List<Integer> array = new ArrayList<>();
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.inOrder(t2.root);
        serialize(t2.root,array);
        System.out.println("Serialized Array :"+array);
        t2.inOrder(deserialize(array));
    }
}
