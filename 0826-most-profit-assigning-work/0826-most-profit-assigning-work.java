class Solution {
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        int m= w.length;
        int n=p.length;
        List<int[]> temp= new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new int[]{d[i],p[i]});
        }
        // sort the list accordingt to the difficulty
        Collections.sort(temp,(a,b)-> Integer.compare(a[0], b[0]));
        // Pre-processing to find the maximum profit till index i at constant time

        for(int i=1;i<temp.size();i++){
            temp.get(i)[1]=Math.max(temp.get(i-1)[1],temp.get(i)[1]);
        }

        //Arrays.sort(w);
        int totalProfit=0;

        for(int i=0;i<m;i++){
            int level=w[i];

            int l=0;
            int r= temp.size()-1;
            int maxProfit=0;
            while(l<=r){
                int mid = l + (r-l)/2;

                if(temp.get(mid)[0]<=level){
                    maxProfit=Math.max(maxProfit,temp.get(mid)[1]);
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }

            }
            totalProfit +=maxProfit;
        }
        return totalProfit;
    }
}