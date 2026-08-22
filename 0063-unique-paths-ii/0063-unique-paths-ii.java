class Solution {
    public int count(int i, int j,int[][] ab,int[][] dp ){
        int m= ab.length;
        int n=ab[0].length;
        if(i==m || j==n) return 0;
        if(ab[i][j]==1) return 0;
        
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] !=-1) return  dp[i][j];
        int right=count(i+1, j, ab,dp);
        int left=count(i,j+1,ab,dp);
        return dp[i][j]= left+ right;
    }
    public int uniquePathsWithObstacles(int[][] ab) {
        int m= ab.length;
        int n=ab[0].length;
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return count(0,0,ab,dp);
    }
}