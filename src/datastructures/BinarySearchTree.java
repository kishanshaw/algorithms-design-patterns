package datastructures;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree(Node node) {
        this.root = node;
    }

    public Node insert(Node root, int newVal) {
        if (root == null) {
            return new Node(newVal);
        } else if (root.getData() > newVal) {
            root.leftChild = insert(root.leftChild, newVal);
        } else if (root.getData() < newVal) {
            root.rightChild = insert(root.rightChild, newVal);
        }
        return root;
    }

    public boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.getData() == val) {
            return true;
        } else if (root.getData() > val) {
            return search(root.getLeftChild(), val);
        } else {
            return search(root.getRightChild(), val);
        }
    }
}

