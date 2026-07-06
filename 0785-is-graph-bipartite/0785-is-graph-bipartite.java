class Solution {
    static boolean ans;
    public void bfs(int i,int[][] graph, int[] vis ){
        vis[i]=0;
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int top= q.remove();
            int col= vis[top];
            for(int ele : graph[top]){
                if(vis[ele] == vis[top]){
                    ans=false;
                    return;
                }
                if(vis[ele]==-1){
                    vis[ele]= 1-col;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        ans= true;
        int n= graph.length;
        int[] vis= new int[n];
        
        Arrays.fill(vis,-1);

        for(int i=0;i<n;i++){
            if(ans==false) return ans;
            if(vis[i]==-1) bfs(i,graph,vis);
        }
        return ans;
    }
}