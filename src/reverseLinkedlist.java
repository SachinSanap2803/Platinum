public class reverseLinkedlist {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original Linkedlist : ");
        printList(head);

        head = reverseLL(head);
        System.out.print("Reverse Linkedlist : ");
        printList(head);
    }

    public static ListNode reverseLL(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//
//        return prev;

        if(head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}