class Solution {
    public int count(int n, int[] dp){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n] !=-1) return dp[n];
        return dp[n]= count(n-1,dp) + count(n-2,dp) + count(n-3,dp);
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return count(n,dp);
    }
}