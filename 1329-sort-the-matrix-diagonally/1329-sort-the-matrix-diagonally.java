class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length;
        int n= mat[0].length;
        Map<Integer,PriorityQueue<Integer>> mp= new HashMap<>();
        int[][] ans= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                if(!mp.containsKey(key)){
                    mp.put(key,new PriorityQueue<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i-j;
                ans[i][j]=mp.get(key).poll();
            }
        }
        return ans;
    }
}