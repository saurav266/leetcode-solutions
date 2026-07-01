class Solution {
    public void bfs(int i,List<List<Integer>> rooms, boolean[] vis){
        vis[i]= true;
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front = q.remove();

            for(int ele : rooms.get(front)){
                if(!vis[ele]){
                    vis[ele]= true;
                    q.add(ele);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] vis= new boolean[n];
        vis[0]= true;
        bfs(0,rooms,vis);

        for(int i=0;i<n;i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
}