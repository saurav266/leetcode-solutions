class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean canCross(int row, int col, int[][] cells, int day){
        int[][] grid= new int[row][col];

        for(int i=0;i<day;i++){
            int r= cells[i][0] -1;
            int c= cells[i][1] -1;
            grid[r][c]=1;
        }

        Queue<int[]> q= new LinkedList<>();
        boolean[][] vis= new boolean[row][col];

        for(int i=0;i<col;i++){
            if(grid[0][i]==0){
                q.add(new int[]{0,i});
                vis[0][i]=true;
            }
        }

        while(!q.isEmpty()){
            int[] curr= q.poll();
            int r=curr[0];
            int c=curr[1];

            if(r==row-1) return true;

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc= c+d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col &&
                    !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }

        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left=1;
        int right=cells.length;
        int ans=0;

        while(left<=right){
            int mid= left + (right-left)/2;

            if(canCross(row,col,cells,mid)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}