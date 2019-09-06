package linkedlist;
public class ReverseLinkedList {
    public static LinkedList reverse(LinkedList list) {
        LinkedList.Node current = list.head;
        LinkedList.Node prev = null;
        LinkedList.Node next = null;
        while(current !=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
        return list;
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = LinkedList.insert(list, 1);
        list = LinkedList.insert(list, 2);
        list = LinkedList.insert(list, 3);
        list = LinkedList.insert(list, 4);
        list = LinkedList.insert(list, 5);
        list = LinkedList.insert(list, 6);
        list = LinkedList.insert(list, 7);
        list = LinkedList.insert(list, 8);
        reverse(list);
        LinkedList.printList(list);
    }
}
