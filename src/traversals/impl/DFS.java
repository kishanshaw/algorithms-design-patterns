package traversals.impl;

import traversals.GraphTraversal;

import java.util.List;

public class DFS implements GraphTraversal {
    @Override
    public void traverse(List<List<Integer>> graph, int noForVertices) {
        boolean[] visited = new boolean[noForVertices];
        for (int vertex = 0; vertex < noForVertices; ++vertex) {
            if (!visited[vertex]) {
                helper(graph, visited, vertex);
            }
        }
    }

    public void helper(List<List<Integer>> graph, boolean[] visited, int source) {
        visited[source] = true;
        System.out.printf(" %d", source);
        for (Integer adjacentVertex : getAdjacentNodes(graph, source)) {
            if (!visited[adjacentVertex]) {
                visited[adjacentVertex] = true;
                helper(graph, visited, adjacentVertex);
            }
        }
    }

    private List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        return graph.get(vertex);
    }
}
