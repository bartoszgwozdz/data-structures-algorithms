package datastructures.doubleLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
            head = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length++;

    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        }
        Node temp = tail;
        tail = temp.prev;
        tail.next = null;
        length--;
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head != null) {
            System.out.println("Head: " + head.value);
        } else {
            System.out.println("Head: NULL");
        }
    }

    public void getTail() {
        if (tail != null) {
            System.out.println("Tail: " + tail.value);
        } else {
            System.out.println("Tail: NULL");
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public class Node {
        public int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
