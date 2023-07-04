package traversals.impl;

import traversals.GraphTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS implements GraphTraversal {
    @Override
    public void traverse(List<List<Integer>> graph, int noForVertices) {
        boolean[] visited = new boolean[noForVertices];
        for (int vertex = 0; vertex < noForVertices; vertex++) {
            if (!visited[vertex]) {
                helper(graph, visited, vertex);
            }
        }
    }

    public void helper(List<List<Integer>> graph, boolean[] visited, int source) {
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.printf(" %d", vertex);
            for (Integer adjacentVertex : getAdjacentNodes(graph, vertex)) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.offer(adjacentVertex);
                }
            }
        }
    }

    public List<Integer> getAdjacentNodes(List<List<Integer>> graph, int u) {
        return graph.get(u);
    }
}


