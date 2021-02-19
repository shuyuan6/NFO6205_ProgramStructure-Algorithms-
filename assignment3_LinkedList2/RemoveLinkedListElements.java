package assignment3_LinkedList2;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        ListNode prev = dummyHead;

        while(curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;

            }
            curr = curr.next;

        }
        return dummyHead.next;
    }
}
