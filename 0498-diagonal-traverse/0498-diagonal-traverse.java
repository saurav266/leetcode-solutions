class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n= mat[0].length;
        List<Integer> res= new ArrayList<>();
        Map<Integer,List<Integer>> mp= new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key= i+j;
                if(!mp.containsKey(key)){
                    mp.put(key,new ArrayList<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }

        for(int k=0;k<=m+n-2;k++){
            List<Integer> ls= mp.get(k);
            if(k%2==0){
                Collections.reverse(ls);
            }
            res.addAll(ls);
        }

        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        return output;
    }
}