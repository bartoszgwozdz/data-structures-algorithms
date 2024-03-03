package datastructures.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    public Node root;

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            return insert(root, newNode);
        }
    }

    private boolean insert(Node local, Node newNode) {
        if (newNode.value > local.value) {
            if (local.right == null) {
                local.right = newNode;
                return true;
            } else {
                return insert(local.right, newNode);
            }
        } else if (newNode.value < local.value) {
            if (local.left == null) {
                local.left = newNode;
                return true;
            } else {
                return insert(local.left, newNode);
            }
        }
        return false;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while(queue.size() > 0){
            currentNode = queue.remove();
            results.add(currentNode.value);
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public boolean contains(int value){
        if(root==null) return false;
        return contains(value, root);
    }

    private boolean contains(int value, Node node){
        if(node == null) return false;
        if(node.value == value) return true;
        if(value < node.value) return contains(value, node.left);
        else return contains(value, node.right);
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
