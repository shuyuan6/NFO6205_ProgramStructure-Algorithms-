package assignment2_LinkedList;

public class InsertIntoASortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {

        Node newNode = new Node(insertVal);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        Node next = head.next;

        Node maxNode = new Node(Integer.MIN_VALUE);
        Node minNode = new Node(Integer.MAX_VALUE);

        while (true) {
            if (curr.val >= maxNode.val) {
                maxNode = curr;
            }
            if (curr.val < minNode.val) {
                minNode = curr;
            }
            curr = curr.next;
            if (curr == head) {
                break;
            }
        }

        if (insertVal <= minNode.val || insertVal >= maxNode.val) {
            maxNode.next = newNode;
            newNode.next = minNode;
        } else {
            while (true) {
                if ((curr.val <= insertVal) && (insertVal <= next.val)) {
                    curr.next = newNode;
                    newNode.next = next;
                    break;
                } else {
                    curr = curr.next;
                    next = curr.next;
                    if (curr == head) {
                        break;
                    }
                }
            }
        }

        return head;
    }
}
