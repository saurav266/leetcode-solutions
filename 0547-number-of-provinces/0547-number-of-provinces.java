class Solution {
    public void bfs(int i,int[][] adj, boolean[] vis){
        int n= adj.length;
        vis[i]=true;
        Queue<Integer> q= new LinkedList<>();

        q.add(i);
        while(q.size()>0){
            int top=q.remove();

            for(int j=0;j<n;j++){
                if(adj[top][j]==1 && vis[j]==false){
                    vis[j]=true;
                    q.add(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n= adj.length;
        boolean[] vis= new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                bfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}