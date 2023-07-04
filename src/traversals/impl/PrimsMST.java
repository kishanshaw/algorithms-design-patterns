package traversals.impl;

import java.util.Arrays;

public class PrimsMST {

    public int getMinDistance(int[][] graph, int noOfVertices) {
        int minDistance = 0;
        boolean[] isIncluded = new boolean[noOfVertices];
        int[] key = new int[noOfVertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        for (int count = 0; count < noOfVertices; count++) {
            int selectedVertex = -1;
            for (int vertex = 0; vertex < noOfVertices; ++vertex) {
                if (!isIncluded[vertex] && (selectedVertex == -1 || key[vertex] < key[selectedVertex])) {
                    selectedVertex = vertex;
                }
            }
            isIncluded[selectedVertex] = true;
            minDistance += key[selectedVertex];

            for (int adjacentVertex = 0; adjacentVertex < noOfVertices; adjacentVertex++) {
                if (!isIncluded[adjacentVertex]
                        && graph[selectedVertex][adjacentVertex] != 0
                        && key[adjacentVertex] > graph[selectedVertex][adjacentVertex]) {
                    key[adjacentVertex] = graph[selectedVertex][adjacentVertex];
                }
            }
        }
        return minDistance;
    }
}
