package assignment2_LinkedList;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode curr = root;
        while(curr != null) {
            length++;
            curr = curr.next;
        }

        int size = length / k;
        int countOfLargeGroups = length % k;

        ListNode[] res = new ListNode[k];
        curr = root;

        for (int i = 0; i < k && curr != null; i++) {
            res[i] = curr;
            //System.out.println("curr: " + curr.val);

            if (countOfLargeGroups > 0) {
                for (int j = 0; j < size; j++) {
                    curr = curr.next;
                }

            } else {
                for (int j = 0; j < size - 1; j++) {
                    curr = curr.next;
                }
            }

            countOfLargeGroups--;
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }

        return res;
    }
}
