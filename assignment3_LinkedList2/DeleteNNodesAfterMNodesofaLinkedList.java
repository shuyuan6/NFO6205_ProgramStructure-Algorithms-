package assignment3_LinkedList2;

public class DeleteNNodesAfterMNodesofaLinkedList {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            for (int i = 1; i < m + n; i++) {
                if (curr != null) {
                    //System.out.println("curr: " + curr.val + ", prev: " + prev.val);
                    if (i < m) {
                        curr = curr.next;
                        prev = prev.next;
                    } else {
                        curr = curr.next;
                    }
                }
            }
            if (curr != null) {
                curr = curr.next;
                prev.next = curr;
                prev = curr;
            }
        }
        if (prev != null) {
            prev.next = null;
        }
        return head;
    }
}
