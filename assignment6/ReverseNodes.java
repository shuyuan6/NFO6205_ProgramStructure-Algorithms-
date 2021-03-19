package assignment6;

public class ReverseNodes {
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode newHead = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode nextNode = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = nextNode;
            k--;
        }

        return newHead;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;


        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            ListNode newHead = reverseKNodes(head, k);
            head.next = reverseKGroup(curr, k);
            return newHead;
        }

        return head;
    }
}
