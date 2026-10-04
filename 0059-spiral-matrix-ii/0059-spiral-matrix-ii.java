class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        if(n==0) return ans;
        int minr=0,minc=0,maxr=n-1,maxc=n-1;
        int num=1;
        while(minr<=maxr && minc<=maxc){
            for(int j=minc;j<=maxc;j++){
                ans[minr][j]=num++;
            }
            minr++;
            for(int i=minr;i<=maxr;i++){
                ans[i][maxc]=num++;
            }
            maxc--;
            for(int j=maxc;j>=minc;j--){
                ans[maxr][j]=num++;
            }
            maxr--;
            for(int i=maxr;i>=minr;i--){
                ans[i][minc]=num++;
            }
            minc++;
        }
        return ans;
    }
}