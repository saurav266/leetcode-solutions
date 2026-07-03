class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE / 2; // avoid overflow
            }
        }

        // Fill edge weights
        for (int[] arr : edges) {
            int u = arr[0], v = arr[1], wt = arr[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd–Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Find city with minimum reachable neighbors
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= threshold) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                minCity = i; // prefer larger index if tie
            }
        }

        return minCity;
    }
}
