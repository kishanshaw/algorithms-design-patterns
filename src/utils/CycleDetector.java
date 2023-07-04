package utils;

import java.util.List;

public class CycleDetector {

    private boolean helper(List<List<Integer>> graph, boolean[] visited, int vertex, int parent) {
        visited[vertex] = true;
        for (Integer adjacentNode : getAdjacentNodes(graph, vertex)) {
            if (!visited[adjacentNode]) {
                if (helper(graph, visited, adjacentNode, vertex)) {
                    return true;
                }
            } else {
                if (adjacentNode != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclePresentInUndirectedGraph(List<List<Integer>> graph, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                if (helper(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCyclePresentInDirectedGraph(List<List<Integer>> graph, int noOfVertices) {
        boolean[] visited = new boolean[noOfVertices];
        boolean[] recursionStackPresence = new boolean[noOfVertices];
        for (int vertex = 0; vertex < noOfVertices; vertex++) {
            if (!visited[vertex]) {
                if (helper(graph, vertex, visited, recursionStackPresence)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] recursionStackPresence) {
        visited[vertex] = true;
        recursionStackPresence[vertex] = true;
        for (Integer adjacentNode : getAdjacentNodes(graph, vertex)) {
            if (!visited[adjacentNode]) {
                if (helper(graph, adjacentNode, visited, recursionStackPresence)) {
                    return true;
                }
            } else {
                if (recursionStackPresence[adjacentNode]) {
                    return true;
                }
            }
        }
        recursionStackPresence[vertex] = false;
        return false;
    }

    private List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        return graph.get(vertex);
    }
}
