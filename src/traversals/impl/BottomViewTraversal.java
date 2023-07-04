package traversals.impl;

import datastructures.HorizontalDistanceNode;
import datastructures.Node;
import traversals.TreeTraversal;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewTraversal implements TreeTraversal {
    @Override
    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<HorizontalDistanceNode> queue = new LinkedList<>();
        queue.add(new HorizontalDistanceNode(root, 0));
        while (!queue.isEmpty()) {
            HorizontalDistanceNode augmentedNode = queue.poll();
            Node node = augmentedNode.getNode();
            int hd = augmentedNode.getHd();
            map.put(hd, node.getData());
            if (node.getLeftChild() != null) {
                queue.add(new HorizontalDistanceNode(node.getLeftChild(), hd - 1));
            }
            if (node.getRightChild() != null) {
                queue.add(new HorizontalDistanceNode(node.getRightChild(), hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
}
