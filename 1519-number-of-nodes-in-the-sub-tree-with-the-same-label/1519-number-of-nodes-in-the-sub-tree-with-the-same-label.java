import java.util.*;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] ans = new int[n];
        dfs(0, -1, adj, labels, ans);
        return ans;
    }

    private int[] dfs(int node, int parent, List<List<Integer>> adj, String labels, int[] ans) {
        int[] count = new int[26];
        // mark current node’s label
        count[labels.charAt(node) - 'a'] = 1;

        for (int child : adj.get(node)) {
            if (child == parent) continue;
            int[] childCount = dfs(child, node, adj, labels, ans);
            // merge child counts
            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }

        ans[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}
