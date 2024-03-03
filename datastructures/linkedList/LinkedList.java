package datastructures.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = tail = newNode;

        length = 1;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public Node get(int index) {
        if (index >= length || index < 0) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        if (index == 0) return head;
        else if (index == length - 1) return tail;
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node pre = get(index - 1);
            newNode.next = pre.next;
            pre.next = newNode;
        }
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node pre = get(index - 1);
            Node removed = pre.next;
            pre.next = removed.next;
            return removed;
        }
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        while(after!=null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        length--;
        if (length == 0) tail = null;
        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
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

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
