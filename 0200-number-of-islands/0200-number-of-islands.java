class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int i,int j,char[][] grid,boolean[][] v ){
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
         
        int m= grid.length;
        int n=grid[0].length;
        

        while(q.size()>0){
            Pair front= q.remove();
            int row= front.row, col= front.col;
            // top row-1, col
            
            if(row>0){
                if(v[row-1][col]== false && grid[row-1][col]=='1'){
                    q.add(new Pair(row-1,col));
                    v[row-1][col]=true;
                }
            }
            // bottom row+1, col
            
            if((row+1)<m){
                if(v[row+1][col]== false && grid[row+1][col]=='1'){
                    q.add(new Pair(row+1,col));
                    v[row+1][col]=true;
                }
            }

            // left row1, col-1;
            
            if(col>0){
                if(v[row][col-1]== false && grid[row][col-1]=='1'){
                    q.add(new Pair(row,col-1));
                    v[row][col-1]=true;
                }
            }
            // right row1, col+1;
            
            if((col+1)<n){
                if(v[row][col+1]== false && grid[row][col+1]=='1'){
                    q.add(new Pair(row,col+1));
                    v[row][col+1]=true;
                }
            }

        }

    }
    public void dfs(int i,int j,char[][] grid,boolean[][] v ){
        int m= grid.length;
        int n=grid[0].length;
        v[i][j]= true;

        if(i-1>=0 && grid[i-1][j]=='1' &&  v[i-1][j]==false)dfs(i-1,j,grid,v);
        if(i+1<m && grid[i+1][j]=='1' &&  v[i+1][j]==false)dfs(i+1,j,grid,v);
        if(j-1>=0 && grid[i][j-1]=='1' &&  v[i][j-1]==false)dfs(i,j-1,grid,v);
        if(j+1<n && grid[i][j+1]=='1' &&  v[i][j+1]==false)dfs(i,j+1,grid,v);


    }
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] v= new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && v[i][j]==false){
                    // bfs(i,j,grid,v);
                    dfs(i,j,grid,v);
                    count++;
                }
            }
        }
        return count;
    }
}