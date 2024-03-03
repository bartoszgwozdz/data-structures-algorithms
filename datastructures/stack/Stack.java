package datastructures.stack;

import java.util.ArrayList;

public class Stack {

    private Node top;
    private int height;

    ArrayList<String> arrayList = new ArrayList<>();


    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height++;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top=newNode;
        } else {
            newNode.next = top;
            top = newNode;
        } height++;
    }

    public Node pop(){
        if(height==0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void getTop(){
        System.out.println("Top: " + top.value);
    }

    public void getHeight(){
        System.out.println("Height: " + height);
    }

    public class Node {
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
}