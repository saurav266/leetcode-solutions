class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n= nums.length;
        long[] conver= new long[n];
        int maxEle=nums[0];
        for(int i=0;i<n;i++){
            maxEle=Math.max(maxEle,nums[i]);
            conver[i]= nums[i]+maxEle;
        }

        for(int i=1;i<n;i++){
            conver[i]= conver[i]+ conver[i-1];
        }
        return conver;
    }
}