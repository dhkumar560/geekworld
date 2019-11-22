package linkedlist;

public class ReverseLinkListInGroup {
    Node head;

    public static Node reverseInGroup(Node node,int k){
        Node curr = node;
        Node prev = null;
        Node next = null;
        int count =0;
        while(count < k && curr!=null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            node.next = reverseInGroup(next,k);
        }
        return prev;
    }


    public static void main(String[] args) {
    Node node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    node.next.next.next.next = new Node(5);
    node.next.next.next.next.next = new Node(6);
    node.next.next.next.next.next.next = new Node(7);
    node.next.next.next.next.next.next.next = new Node(8);
    node.next.next.next.next.next.next.next.next = new Node(9);
    printList(node);
    Node n=reverseInGroup(node,5);
    printList(n);
}
    public static void printList(Node currNode) {
        System.out.println("The Linked List is :");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
            if(currNode!=null){
                System.out.print("-->");
            }
        }
    }}
class Node {
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
    public Node(){
    }
}
