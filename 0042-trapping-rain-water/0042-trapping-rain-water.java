class Solution {
    public int trap(int[] h) {
        int n= h.length;
        int[] left= new int[n];
        int[] right= new int[n];

        int maxLen=h[0];
        left[0]=0;

        for(int i=1;i<n;i++){
            left[i]=maxLen;
            maxLen=Math.max(h[i],maxLen);
        }
        maxLen=h[n-1];
        right[n-1]=0;
        for(int i=n-2;i>=0;i--){
            right[i]=maxLen;
            maxLen=Math.max(maxLen,h[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int sum =Math.min(left[i],right[i])-h[i];
            if(sum>0) ans +=sum;
        }
        return ans;
    }
}