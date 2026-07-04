class Solution {
    public class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj= new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(1,Integer.MAX_VALUE));
        boolean[] vis= new boolean[n+1];
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair top= q.remove();
            int node=top.node;
            int dist=top.dist;
            vis[node]=true;
            ans=Math.min(dist,ans);
            for(Pair p : adj.get(node)){
                
                if(!vis[p.node]){
                    q.add(p);
                }
            }

        }
        return ans;
    }
}