class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        
        int[][] maxScore = new int[n][n];
        int[][] ways = new int[n][n];
        
        for (int i = 0; i < n; i++) Arrays.fill(maxScore[i], -1);
        
        maxScore[n-1][n-1] = 0;
        ways[n-1][n-1] = 1;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') continue; // obstacle
                if (i == n-1 && j == n-1) continue; // skip 'S'
                
                int val = (c == 'E') ? 0 : c - '0';
                int best = -1, count = 0;
                
                // check three possible moves: down, right, diagonal
                int[][] dirs = {{1,0},{0,1},{1,1}};
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < n && nj < n && maxScore[ni][nj] != -1) {
                        int candidate = maxScore[ni][nj] + val;
                        if (candidate > best) {
                            best = candidate;
                            count = ways[ni][nj];
                        } else if (candidate == best) {
                            count = (count + ways[ni][nj]) % MOD;
                        }
                    }
                }
                maxScore[i][j] = best;
                ways[i][j] = count;
            }
        }
        
        return maxScore[0][0] == -1 ? new int[]{0,0} : new int[]{maxScore[0][0], ways[0][0]};
    }
}
