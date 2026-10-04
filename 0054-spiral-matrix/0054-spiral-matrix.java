class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        List<Integer> ans= new ArrayList<>();
        int minR=0;
        int maxR=m-1;

        int minC=0;
        int maxC=n-1;

        while(minR<=maxR && minC <=maxC){
            for(int j=minC ;j<=maxC;j++){
                ans.add(matrix[minR][j]);
            }
            minR++;
            if(minR>maxR || minC>maxC) break;
            for(int i=minR ;i<=maxR;i++){
                ans.add(matrix[i][maxC]);
            }
            maxC--;

            if(minR>maxR || minC>maxC) break;
            for(int j=maxC;j>=minC;j--){
                ans.add(matrix[maxR][j]);
            }
            maxR--;
            if(minR>maxR || minC>maxC) break;
            for(int i=maxR;i>=minR;i--){
                ans.add(matrix[i][minC]);
            }
            minC++;
        }
        return ans;
    }
}