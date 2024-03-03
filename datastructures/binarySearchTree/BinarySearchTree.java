package datastructures.binarySearchTree;

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
