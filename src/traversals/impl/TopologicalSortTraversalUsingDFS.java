package traversals.impl;

import traversals.GraphTraversal;

import java.util.List;
import java.util.Stack;

public class TopologicalSortTraversalUsingDFS implements GraphTraversal {
    @Override
    public void traverse(List<List<Integer>> graph, int noForVertices) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noForVertices];
        for (int vertex = 0; vertex < noForVertices; vertex++) {
            if (!visited[vertex]) {
                helper(graph, vertex, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
    }

    private void helper(List<List<Integer>> graph, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (Integer adjacentNode : getAdjacentNodes(graph, vertex)) {
            if (!visited[adjacentNode]) {
                helper(graph, adjacentNode, visited, stack);
            }
        }
        stack.push(vertex);
    }

    private List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        return graph.get(vertex);
    }

    public void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }
}
