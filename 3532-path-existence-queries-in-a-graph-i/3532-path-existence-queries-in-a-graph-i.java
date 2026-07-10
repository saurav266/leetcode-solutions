class Solution {
    public void bfs(int start, int compId,List<List<Integer>> adj, int[] comp){
        comp[start]= compId;
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int node= q.poll();

            for(int nie : adj.get(node)){
                if(comp[nie]==-1){
                    comp[nie]= compId;
                    q.add(nie);
                }
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=maxDiff){
                adj.get(i).add(i+1);
                adj.get(i+1).add(i);
            }
        }
        int[] comp = new int[n];
        Arrays.fill(comp,-1);
        int compId=0;

        for(int i=0;i<n;i++){
            if(comp[i]==-1){
                bfs(i,compId,adj,comp);
                compId++;
            }
        }

        boolean[] ans= new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int u = queries[i][0], v = queries[i][1];
            ans[i] = (comp[u] == comp[v]);
        }
        return ans;
    }

}