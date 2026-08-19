class Solution {
    public void dfs(int[][] stones,boolean[] vis, int idx){
        vis[idx]=true;
        for(int j=0;j<stones.length;j++){
            if(!vis[j]){
                if (stones[idx][0] == stones[j][0] || stones[idx][1] == stones[j][1]) {
                    dfs(stones, vis, j);
                }
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n= stones.length;
        boolean[] vis= new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(stones,vis,i);
                group++;
            }
        }
        return n-group;
    }
}