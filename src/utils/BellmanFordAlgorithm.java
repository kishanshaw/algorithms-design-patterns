package utils;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    private final int V, E;
    private final Edge[] edges;

    public BellmanFordAlgorithm(int v, int e) {
        this.V = v;
        this.E = e;
        edges = new Edge[e];
    }

    public Edge[] getEdges() {
        return edges;
    }

    public int[] getShortestDistance(int source) {
        int[] dist = new int[this.V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int count = 0; count < V - 1; count++) {
            for (int edge = 0; edge < E; edge++) {
                int u = edges[edge].src;
                int v = edges[edge].dest;
                int w = edges[edge].wt;
                if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        return dist;
    }

    public void addEdge(int edgeNum, int src, int dest, int wt) {
        edges[edgeNum] = new Edge(src, dest, wt);
    }


    static class Edge {
        private final int src;
        private final int dest;
        private final int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public int getSource() {
            return this.src;
        }

        public int getDestination() {
            return this.dest;
        }

        public int getWeight() {
            return this.wt;
        }
    }
}
