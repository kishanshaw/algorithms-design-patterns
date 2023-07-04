package traversals.impl;

import traversals.GraphTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortTraversalUsingBFS implements GraphTraversal {
    @Override
    public void traverse(List<List<Integer>> graph, int noForVertices) {
        int[] inDegrees = getInDegrees(graph, noForVertices);
        Queue<Integer> queue = new LinkedList<>();
        addZeroDegreeVertexToQueue(queue, inDegrees);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.printf(" %d", vertex);
            for (Integer adjacentNode : getAdjacentNodes(graph, vertex)) {
                inDegrees[adjacentNode]--;
                if (inDegrees[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
    }

    private void addZeroDegreeVertexToQueue(Queue<Integer> queue, int[] inDegrees) {
        for (int vertex = 0; vertex < inDegrees.length; ++vertex) {
            if (inDegrees[vertex] == 0) {
                queue.offer(vertex);
            }
        }
    }

    private int[] getInDegrees(List<List<Integer>> graph, int noOfVertices) {
        int[] inDegrees = new int[noOfVertices];
        for (int vertex = 0; vertex < noOfVertices; vertex++) {
            for (Integer node : getAdjacentNodes(graph, vertex)) {
                inDegrees[node]++;
            }
        }
        return inDegrees;
    }

    private List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        return graph.get(vertex);
    }

    public void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }
}
