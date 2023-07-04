package traversals.impl;

import datastructures.HorizontalDistanceNode;
import datastructures.Node;
import traversals.TreeTraversal;

import java.util.*;

public class VerticalOrderTraversal implements TreeTraversal {
    @Override
    public void traverse(Node root) {
        if (root == null) {
            return;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<HorizontalDistanceNode> queue = new LinkedList<>();
        queue.add(new HorizontalDistanceNode(root, 0));
        while (!queue.isEmpty()) {
            HorizontalDistanceNode augmentedNode = queue.poll();
            int hd = augmentedNode.getHd();
            Node node = augmentedNode.getNode();
            if (map.containsKey(hd)) {
                map.get(hd).add(node.getData());
            } else {
                List<Integer> newNodeList = new ArrayList<>();
                newNodeList.add(node.getData());
                map.put(hd, newNodeList);
            }

            if (node.getLeftChild() != null) {
                queue.add(new HorizontalDistanceNode(node.getLeftChild(), hd - 1));
            }
            if (node.getRightChild() != null) {
                queue.add(new HorizontalDistanceNode(node.getRightChild(), hd + 1));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
