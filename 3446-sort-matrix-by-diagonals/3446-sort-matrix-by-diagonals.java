class Solution {
    public int[][] sortMatrix(int[][] grid) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i - j)) {
                    if (i - j < 0)
                        map.put(i - j, new PriorityQueue<>());
                    else
                        map.put(i - j, new PriorityQueue<>(Collections.reverseOrder()));

                }
                map.get(i - j).add(grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = map.get(i - j).poll();
            }
        }
        return grid;
    }
}