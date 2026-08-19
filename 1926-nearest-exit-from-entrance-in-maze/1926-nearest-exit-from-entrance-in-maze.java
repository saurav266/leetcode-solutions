class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n= maze[0].length;
        boolean[][] vis= new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1]});
        vis[entrance[0]][entrance[1]]=true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int steps=0;
        while(!q.isEmpty()){
            int s= q.size();
            while(s-- > 0){
                int[] top= q.poll();
                int u=top[0];
                int v=top[1];
                if((u==0 || u==m-1 || v==0 || v==n-1)&& !(u==entrance[0] && v==entrance[1])){
                    return steps;
                }
                for(int[] d: dirs){
                    int nx=u + d[0];
                    int ny= v+ d[1];

                    if(nx>=0 && nx<m && ny >=0 && ny<n && maze[nx][ny]=='.' && !vis[nx][ny]){
                        vis[nx][ny]=true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            steps++;

        }
        return -1;
    }
}