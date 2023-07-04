package utils;

import java.util.*;

public class DijkstraAlgorithm {

    private final List<List<Node>> graph = new ArrayList<>();

    public DijkstraAlgorithm() {
    }

    public DijkstraAlgorithm(int noOfVertices) {
        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public int[] getShortestDistance(List<List<Node>> graph, int V, int source) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        pq.add(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node adjacentNode : graph.get(node.vertex)) {
                if (distance[adjacentNode.vertex] > distance[node.vertex] + adjacentNode.weight) {
                    distance[adjacentNode.vertex] = distance[node.vertex] + adjacentNode.weight;
                    pq.add(new Node(adjacentNode.vertex, distance[adjacentNode.vertex]));
                }
            }
        }
        return distance;
    }

    public List<List<Node>> getNodes() {
        return this.graph;
    }

    public void addWeightedEdge(int u, int v, int weight) {
        graph.get(u).add(new Node(v, weight));
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }
}
