class Solution {
    public void bfs(int start,List<List<Integer>> adj, boolean[] v){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front =q.remove();
            for(int ele: adj.get(front)){
                if(!v[ele]){
                    q.add(ele);
                    v[ele]=true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list= new ArrayList<>();
            adj.add(list); 
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0], b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] v= new boolean[n];
        v[start]=true;
        bfs(start,adj,v);
        return v[end]; 
    }
}