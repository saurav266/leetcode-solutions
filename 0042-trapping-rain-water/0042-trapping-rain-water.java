class Solution {
    public int trap(int[] h) {
        int n= h.length;
        int[] prefix= new int[n];
        int maxLen=h[0];
        prefix[0]=0;
        for(int i=1;i<n;i++){
            prefix[i]=maxLen;
            maxLen= Math.max(h[i],maxLen);
        }
        maxLen=h[n-1];
        int[] suf= new int[n];
        suf[0]=0;
        for(int i=n-2;i>=0;i--){
            suf[i]=maxLen;
            maxLen=Math.max(h[i],maxLen);
        }
        int total=0;
        for(int i=0;i<n;i++){
            int sum=Math.min(prefix[i],suf[i])-h[i];
            if(sum>0) total +=sum;
        }
        return total;
    }
}