package utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraphUsingBFS {

    public int[] calculateDistance(List<List<Integer>> graph, int noOfVertices, int source) {
        int[] dist = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int adjacentNode : getAdjacentNodes(graph, vertex)) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    dist[adjacentNode] = dist[vertex] + 1;
                    queue.offer(adjacentNode);
                }
            }
        }
        return dist;
    }

    public List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        return graph.get(vertex);
    }
}
