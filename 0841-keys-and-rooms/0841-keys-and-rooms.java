class Solution {
    public void bfs(List<List<Integer>> rooms, boolean[] vis, int idx){
        vis[idx]=true;
        Queue<Integer> q= new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int top= q.poll();
            for(int ele: rooms.get(top)){
                if(!vis[ele]){
                    vis[ele]=true;
                    q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis= new boolean[n];
        bfs(rooms,vis,0);

        for(int i=0;i<n;i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
}