package assignment2_LinkedList;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();

        // LinkedList: 4 -> 5 -> 1 -> 9
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);

        // Delete 5
        deleteNodeInALinkedList.deleteNode(head1.next);

        // Should print: 4 1 9
        ListNode curr = head1;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();

        //--------------------------------------------------------------------------------

        // LinkedList: 1 -> 2 -> 3 -> 4
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        // Delete 3
        deleteNodeInALinkedList.deleteNode(head2.next.next);

        // Should print: 1 2 4
        ListNode curr2 = head2;
        while(curr2 != null) {
            System.out.print(curr2.val + " ");
            curr2 = curr2.next;
        }
        System.out.println();

        //--------------------------------------------------------------------------------

        ListNode head3 = new ListNode(0);
        head3.next = new ListNode(1);

        // Delete 0
        deleteNodeInALinkedList.deleteNode(head3);

        // Should print: 1
        ListNode curr3 = head3;
        while(curr3 != null) {
            System.out.print(curr3.val + " ");
            curr3 = curr3.next;
        }
        System.out.println();
    }
}
