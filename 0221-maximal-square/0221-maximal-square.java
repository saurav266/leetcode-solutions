class Solution {
    private int rows, cols;
    private char[][] mat;
    private Integer[][] memo;
    private int maxSquare = 0;
    public int maximalSquare(char[][] matrix) {
         rows = matrix.length;
        cols = matrix[0].length;
        mat = matrix;
        memo = new Integer[rows][cols];

        // Explore every cell as potential top-left of a square
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxSquare = Math.max(maxSquare, dfs(i, j));
            }
        }
        return maxSquare * maxSquare;
    }
    private int dfs(int i, int j) {
        // Out of bounds
        if (i >= rows || j >= cols) return 0;

        
        if (memo[i][j] != null) return memo[i][j];

        // If cell is '0', no square can start here
        if (mat[i][j] == '0') return memo[i][j] = 0;

        
        int right = dfs(i, j + 1);
        int down = dfs(i + 1, j);
        int diag = dfs(i + 1, j + 1);

        memo[i][j] = 1 + Math.min(right, Math.min(down, diag));
        return memo[i][j];
    }
}