class Solution {
    public int countOver(int[][] a, int[][] b,int rowOff,int colOff){
        int n= a.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int B_i=i+rowOff;
                int B_j=j+colOff;
                if(B_i<0 || B_i>=n || B_j<0 || B_j>=n) continue;

                if(a[i][j]==1 && b[B_i][B_j]==1) count++;
            }
        }
        return count;
    }
    public int largestOverlap(int[][] a, int[][] b) {
        int n= a.length;
        int maxOver=0;
        for(int rowOff=-n+1;rowOff<n;rowOff++ ){
            for(int colOff=-n+1;colOff<n;colOff++){
                int count=countOver(a,b,rowOff,colOff);
                maxOver=Math.max(maxOver,count);

            }
        }
        return maxOver;
    }
}