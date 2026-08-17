class Solution {
    public boolean isPossible(int[] q , int mid,int n){
        int m= q.length;
        int store=0;

        for(int i=0;i<m;i++){
            if(q[i]%mid==0) store += q[i]/mid;
            else store+= q[i]/mid +1;
        }
        if(store<=n) return true;
        return false;
    }
    public int minimizedMaximum(int n, int[] q) {
        int m= q.length;
        int lo=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(q[i],max);
        }
        int hi=max;
        int ans=0;
        while(lo<=hi){
            int mid = lo +  (hi-lo)/2;

            if(isPossible(q,mid,n)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}