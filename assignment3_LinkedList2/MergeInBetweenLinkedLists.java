package assignment3_LinkedList2;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = list1;
        ListNode curr = dummyHead;

        ListNode aMinus1 = null;
        ListNode bPlus1 = null;

        for (int i = 0; i <= b+1; i++) {
            curr = curr.next;
            if (i == a - 1) {
                aMinus1 = curr;
            }
            if (i == b + 1) {
                bPlus1 = curr;
            }
        }
        aMinus1.next = list2;

        ListNode curr2 = list2;
        ListNode tail2 = null;
        while(curr2 != null) {
            if (curr2.next == null) {
                tail2 = curr2;
            }
            curr2 = curr2.next;
        }

        tail2.next = bPlus1;

        return dummyHead.next;
    }
}
