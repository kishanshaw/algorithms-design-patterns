package utils;

import java.util.*;

public class ShortestPathFinderInDAG {
    private final List<List<Integer>> graph = new ArrayList<>();

    public ShortestPathFinderInDAG(int noOfVertices) {
        for (int i = 0; i < noOfVertices; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < noOfVertices; j++) {
                graph.get(i).add(0);
            }
        }
    }

    public List<List<Integer>> getGraph() {
        return this.graph;
    }

    public int[] getShortestPath(List<List<Integer>> graph, int noOfVertices, int source) {
        int[] dist = new int[noOfVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        //Find topologically sorted list
        List<Integer> topologicalSequence = getTopologicalSequence(graph, noOfVertices);

        // Pick each element from above array, and for their adjacent nodes, perform relaxation
        for (Integer node : topologicalSequence) {
            for (Integer adjacentNode : getAdjacentNodes(graph, node)) {
                if (dist[adjacentNode] > dist[node] + graph.get(node).get(adjacentNode)) {
                    dist[adjacentNode] = dist[node] + graph.get(node).get(adjacentNode);
                }
            }
        }
        return dist;
    }

    private List<Integer> getAdjacentNodes(List<List<Integer>> graph, int vertex) {
        List<Integer> nodes = graph.get(vertex);
        List<Integer> adjacentNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != 0) {
                adjacentNodes.add(i);
            }
        }
        return adjacentNodes;
    }

    private List<Integer> getTopologicalSequence(List<List<Integer>> graph, int noOfVertices) {
        Queue<Integer> queue = new LinkedList<>();
        //Find in-degree array
        int[] inDegrees = getInDegrees(graph, noOfVertices);
        //Add zero degree vertices to queue
        for (int i = 0; i < noOfVertices; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        //pop one by one and reduce adjacent node's degree by 1, if current in-degree of vertex is 0, add in queue
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);
            for (Integer adjacentNode : getAdjacentNodes(graph, vertex)) {
                inDegrees[adjacentNode]--;
                if (inDegrees[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
        return result;
    }

    private int[] getInDegrees(List<List<Integer>> graph, int v) {
        int[] inDegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (graph.get(i).get(j) != 0) {
                    inDegrees[j]++;
                }
            }
        }
        return inDegrees;
    }

    public void addEdge(int u, int v, int weight) {
        this.graph.get(u).set(v, weight);
    }


}
