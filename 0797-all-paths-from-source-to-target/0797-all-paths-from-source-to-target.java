import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(Arrays.asList(0)); 

        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int last = path.get(path.size() - 1);

            if (last == n - 1) {
                ans.add(new ArrayList<>(path));
            } else {
                for (int nei : adj.get(last)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nei);
                    q.offer(newPath);
                }
            }
        }

        return ans;
    }
}
