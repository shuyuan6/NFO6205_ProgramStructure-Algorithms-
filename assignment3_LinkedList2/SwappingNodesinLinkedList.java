package assignment3_LinkedList2;

public class SwappingNodesinLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        if (k > (length + 1) / 2) {
            //System.out.println(String.format("Transform k: %d -> %d", k, length - k + 1));
            k = length - k + 1;
        }

        curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }
        ListNode curr1 = curr;
        //System.out.println("curr: " + curr.val + ", prev: " + prev.val);

        curr = head;
        for (int i = 1; i <= length - k; i++) {
            curr = curr.next;
        }
        ListNode curr2 = curr;

        int temp = curr1.val;
        curr1.val = curr2.val;
        curr2.val = temp;

        return dummyHead.next;
    }
}
