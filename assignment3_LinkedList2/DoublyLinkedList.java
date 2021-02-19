package assignment3_LinkedList2;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addToHead(int newData) {
        size++;
        DoublyNode newNode = new DoublyNode(newData);

        if (head != null) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;

        } else {
            tail = newNode;
            head = newNode;
        }
    }

    public void addToTail(int newData) {
        size++;
        DoublyNode newNode = new DoublyNode(newData);

        if (tail != null) {
            newNode.prev = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }

    public int size() {
        return size;
    }

    public void print() {
        DoublyNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printFrontTail() {
        DoublyNode curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Size: " + list.size());
        list.print();
        list.printFrontTail();
        System.out.println();

        list.addToHead(2);
        System.out.println("Size: " + list.size());
        list.print();
        list.printFrontTail();
        System.out.println();

        list.addToTail(5);
        System.out.println("Size: " + list.size());
        list.print();
        list.printFrontTail();
        System.out.println();

        list.addToHead(1);
        System.out.println("Size: " +list.size());
        list.print();
        list.printFrontTail();
        System.out.println();

        list.addToTail(3);
        System.out.println("Size: " + list.size());
        list.print();
        list.printFrontTail();
        System.out.println();

    }
}
