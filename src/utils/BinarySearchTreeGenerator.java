package utils;

import datastructures.Node;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeGenerator {

    public static List<Node> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private static List<Node> helper(int start, int end) {
        List<Node> possibleTrees = new ArrayList<>();
        if (start > end) {
            possibleTrees.add(null);
            return possibleTrees;
        }
        for (int key = start; key <= end; key++) {
            List<Node> leftTrees = helper(start, key - 1);
            List<Node> rightTrees = helper(key + 1, end);
            for (Node leftTree : leftTrees) {
                for (Node rightTree : rightTrees) {
                    Node root = new Node(key);
                    root.leftChild = leftTree;
                    root.rightChild = rightTree;
                    possibleTrees.add(root);
                }
            }
        }
        return possibleTrees;
    }
}
