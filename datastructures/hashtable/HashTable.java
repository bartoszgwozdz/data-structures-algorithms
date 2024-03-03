package datastructures.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        Node temp = dataMap[index];
        if (temp == null) {
            dataMap[index] = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return Integer.MIN_VALUE;

    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(Node node : dataMap){
            while (node != null) {
                allKeys.add(node.key);
                node = node.next;
            }
        }
        return allKeys;
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (char c : keyChars) {
            int asciValue = c;
            hash = (hash + asciValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("\t{" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
