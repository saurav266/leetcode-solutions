class Solution {
    public int step(int n, int i, int[] dp){
        if(i==n || i==n-1) return 1;
        if(dp[i] != -1) return dp[i];
        int firstStep= step(n,i+1,dp);
        int secondStep = step(n,i+2,dp);
        return dp[i]= firstStep + secondStep;
    }
    public int climbStairs(int n) {
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return step(n,0,dp);
    }
}