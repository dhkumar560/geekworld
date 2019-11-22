package linkedlist;

import static linkedlist.ReverseLinkListInGroup.printList;

public class SumOfTwoLinkList {
    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(4);
        node.next.next = new Node(3);

        Node node1 = new Node(5);
        node1.next = new Node(6);
        node1.next.next = new Node(4);
        printList(node);
        printList(node1);

        Node n1 = reverseLinkedList(node);
        Node n2 = reverseLinkedList(node1);

        int num1 = getNumber(n1);
        int num2 = getNumber(n2);
        Node result =createLinkListFromNum(num1+num2);
        printList(result);

    }
    public static Node createLinkListFromNum(int num){
        Node head = null;
        Node temp ;
        while(num >0){
            int data = num%10;
            Node node = new Node(data);
            if(head == null){
                head = node;
            }
            else {
                temp = head;
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = node;
            }
            num = num/10;
        }
        return head;
    }

    public static  Node reverseLinkedList(Node node) {
        Node prev = null;
        Node next;
        Node curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static int getNumber(Node node) {
        int res = 0;
        while (node != null) {
            res = res * 10 + node.data;
            node = node.next;
        }
        return res;
    }
}
