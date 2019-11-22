package linkedlist;

import java.util.PriorityQueue;

import static linkedlist.ReverseLinkListInGroup.printList;

public class MergeKSortedLinkedList {

    public static Node mergeLinkedLists(Node[] nodes ,int k){
        PriorityQueue<Node> q = new PriorityQueue((a,b)->((Node)a).data - ((Node)b).data);
        for(int i = 0;i<k;i++){
            q.add(nodes[i]);
        }
        Node head = null,tail =null;
        while(!q.isEmpty()){
            Node min = q.poll();
            if(head == null){
                head = tail = min;
            } else {
                tail.next = min;
                tail = min;
            }
            if(min.next !=null){
                q.add(min.next);
            }
        }

return head;
    }

    public static void main(String[] args) {
        int k =3;
        Node[] list = new Node[k];
        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(6);
        node.next.next.next = new Node(9);

        Node node1 = new Node(1);
        node1.next = new Node(5);
        node1.next.next = new Node(7);

        Node node2 = new Node(4);
        node2.next = new Node(8);
        node2.next.next = new Node(10);

        list[0] = node;
        list[1] = node1;
        list[2] = node2;
        Node re = mergeLinkedLists(list,k);
        printList(re);

    }
}
