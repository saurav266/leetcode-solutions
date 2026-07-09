class Solution {
    public int memo(int i,int end,int[] nums,int[] dp){
        if(i>end) return 0;
        if(dp[i] !=-1) return dp[i];

        int pick= nums[i] + memo(i+2, end,nums,dp);
        int skip= memo(i+1,end,nums,dp);
        return dp[i]= Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int one = memo(0,n-2,nums,dp);
        Arrays.fill(dp,-1);
        int two=memo(1,n-1,nums,dp);
        return Math.max(one,two);
    }
}