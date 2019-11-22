package tree;

import java.util.PriorityQueue;

public class SecondSmallestInTree {

    private static PriorityQueue<Node> q = new PriorityQueue<Node>(2,(r1, r2)->r2.data-r1.data);
    public static int findSecondMinimumValue(Node root) {
        if(root == null)
            return 0;
        findSecondMinimumValue(root.left);

        if(q.size()<2 && !q.contains(root)){
            q.offer(root);
        }
        else if(root!=null && q.peek()!=null && q.peek().data > root.data){
            q.poll();
            q.offer(root);
        }
        findSecondMinimumValue(root.right);
        return q.peek()!=null?q.peek().data:-1;
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(5);

        System.out.println(findSecondMinimumValue(root));
    }
}
