class Solution {
    public boolean bfs(List<List<Integer>> adj,int[] color, int idx){
        Queue<Integer> q= new LinkedList<>();
        q.add(idx);
        color[idx]=1;
        while(!q.isEmpty()){
            int node= q.poll();
            for(int ele: adj.get(node)){
                if(color[ele]==0){
                    color[ele]=- color[node];
                    q.offer(ele);
                }
                else if(color[ele]==color[node]) return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        int[] color= new int[n+1];
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                if(!bfs(adj,color,i)) return false;
            }
        }
        return true;
    }
}