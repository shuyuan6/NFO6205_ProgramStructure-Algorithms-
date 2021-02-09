package assignment2_LinkedList;

import java.sql.SQLOutput;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode oddCurr = oddHead;
        ListNode evenHead = head.next;
        ListNode evenCurr = evenHead;

        while (evenCurr != null && evenCurr.next != null) {
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }

        oddCurr.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

        // Input: 1->2->3->4->5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode curr1 = oddEvenLinkedList.oddEvenList(head1);
        // Should print: 1 3 5 2 4
        while (curr1 != null) {
            System.out.print(curr1.val + " ");
            curr1 = curr1.next;
        }
        System.out.println();

        // ------------------------------------------------------------------------------

        // Input: 2->1->3->5->6->4->7
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);

        ListNode curr2 = oddEvenLinkedList.oddEvenList(head2);
        // Should print: 2 3 6 7 1 5 4
        while (curr2 != null) {
            System.out.print(curr2.val + " ");
            curr2 = curr2.next;
        }
        System.out.println();
    }
}
