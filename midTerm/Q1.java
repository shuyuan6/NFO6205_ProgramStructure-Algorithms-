package midTerm;

import java.util.List;

public class Q1 {
    // Assume: the size of linkedlist with head n1 is n, the size of linkedlist with head n1 is m
    // Time complexity: O(m + n + Math.max(m, n))
    // Space complexity: O(1)
    public boolean areConverging(ListNode n1, ListNode n2) {
        ListNode curr = n1;
        int len1 = 0;
        while (curr != null) {
            len1++;
            curr = curr.next;
        } //n

        curr = n2;
        int len2 = 0;
        while (curr != null) {
            len2++;
            curr = curr.next;
        } //m

        ListNode curr1 = n1;
        ListNode curr2 = n2;

        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                curr1 = curr1.next;
            }
        }

        if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            if (curr2 == curr1) {
                return true;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return false;
    }

    public static void main(String[] args) {
        /*
        1
         \
          5 - 9 - 10
         /
    2 - 3
         */

        Q1 test1 = new Q1();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node2;

        System.out.println("The result for test1: " + test1.areConverging(node1, node5));
        //Should be true;

        /*
        0 - 4 - 7 - 8
        11 - 15
         */

        Q1 test2 = new Q1();
        ListNode node11 = new ListNode(0);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(7);
        ListNode node14 = new ListNode(8);
        ListNode node15 = new ListNode(11);
        ListNode node16 = new ListNode(15);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        node15.next = node16;

        System.out.println("The result for test2: " + test2.areConverging(node11, node15));
        //Should be false;
    }
}
