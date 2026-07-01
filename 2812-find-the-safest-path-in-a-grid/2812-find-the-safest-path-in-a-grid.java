class Solution {
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;
        
        int[][] mat = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[] {i, j});
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dir) {
                int di = curr[0] + d[0], dj = curr[1] + d[1];
                if (di >= 0 && di < n && dj >= 0 && dj < n && mat[di][dj] == -1) {
                    mat[di][dj] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[] {di, dj});
                }
            }
        }

        // Priority Queue ordered by maximum minimum safeness factor descending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[] {0, 0, mat[0][0]}); 
        mat[0][0] = -1; 

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) return curr[2];
            
            for (int[] d : dir) {
                int di = d[0] + curr[0], dj = d[1] + curr[1];
                if (di >= 0 && di < n && dj >= 0 && dj < n && mat[di][dj] != -1) {
                    pq.add(new int[] {di, dj, Math.min(curr[2], mat[di][dj])});
                    mat[di][dj] = -1; // Mark visited
                }
            }
        }
        return -1;
    }
}