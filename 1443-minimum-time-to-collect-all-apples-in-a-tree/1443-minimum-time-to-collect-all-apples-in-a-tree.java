class Solution {
     private int dfs(int node, int parent, List<List<Integer>> graph, List<Boolean> hasApple) {
        int total = 0;
        for (int child : graph.get(node)) {
            if (child == parent) continue;
            int childTime = dfs(child, node, graph, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                total += childTime + 2; // go and return
            }
        }
        return total;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return dfs(0, -1, graph, hasApple);
    }
}