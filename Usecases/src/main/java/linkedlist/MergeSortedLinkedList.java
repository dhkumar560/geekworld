package linkedlist;

import static linkedlist.ReverseLinkListInGroup.printList;

public class MergeSortedLinkedList {

    public static Node mergeLinkedList(Node n1, Node n2) {
        Node dummyNode = new Node(0);
        Node temp = dummyNode;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                temp.next = n2;
                break;
            }
            if (n2 == null) {
                temp.next = n1;
                break;
            }
            if (n1.data < n2.data) {
                temp.next = n1;
                n1 = n1.next;
            } else {
                temp.next = n2;
                n2 = n2.next;
            }
            temp = temp.next;

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(5);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(13);
        node.next.next.next.next.next.next = new Node(18);
        node.next.next.next.next.next.next.next = new Node(20);
        node.next.next.next.next.next.next.next.next = new Node(22);

        Node node1 = new Node(6);
        node1.next = new Node(8);
        node1.next.next = new Node(13);
        node1.next.next.next = new Node(17);
        node1.next.next.next.next = new Node(19);
        node1.next.next.next.next.next = new Node(23);
        node1.next.next.next.next.next.next = new Node(27);
        node1.next.next.next.next.next.next.next = new Node(31);
        node1.next.next.next.next.next.next.next.next = new Node(33);

        Node mergedList = mergeLinkedList(node, node1);
        printList(mergedList);
    }
}
