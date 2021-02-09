package assignment2_LinkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode previous = dummyHead;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            previous.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            previous = firstNode;
            head = firstNode.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

        //Input: 1 -> 2 -> 3 -> 4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        ListNode curr1 = swapNodesInPairs.swapPairs(head1);
        //Should print: 2 1 4 3
        while(curr1 != null) {
            System.out.print(curr1.val + " ");
            curr1 = curr1.next;
        }
        System.out.println();

        //------------------------------------------------------------------------

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode curr2 = swapNodesInPairs.swapPairs(head2);
        //Should print: 2 1 4 3 5
        while(curr2 != null) {
            System.out.print(curr2.val + " ");
            curr2 = curr2.next;
        }

    }
}
