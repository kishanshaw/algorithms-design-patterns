package datastructures;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    private final int V;
    private final List<List<Integer>> graph;

    public AdjacencyList(int noOfVertices) {
        this.V = noOfVertices;
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public List<List<Integer>> getGraph() {
        return this.graph;
    }

    public void addEdge(int u, int v) {
        this.graph.get(u).add(v);
        this.graph.get(v).add(u);
    }

    public void printGraphNodes(List<List<Integer>> graph) {
        System.out.println("\n Printing nodes: ");
        for (List<Integer> list : graph) {
            for (Integer node : list) {
                System.out.printf("%d ", node);
            }
            System.out.println();
        }
    }
}
