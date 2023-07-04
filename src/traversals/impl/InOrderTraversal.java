package traversals.impl;

import datastructures.Node;
import traversals.TreeTraversal;

public class InOrderTraversal implements TreeTraversal {
    @Override
    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        traverse(root.getLeftChild());
        System.out.printf("%d ", root.getData());
        traverse(root.getRightChild());
    }
}
