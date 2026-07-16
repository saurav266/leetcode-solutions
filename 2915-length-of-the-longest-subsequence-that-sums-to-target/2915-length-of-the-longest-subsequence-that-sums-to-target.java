class Solution {
    public int helper(int i,List<Integer> nums , int target, int[][] dp){
        if(target==0){
            return 0;
        }
        if(i==nums.size()){
            return Integer.MIN_VALUE;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int skip=helper(i+1,nums,target,dp);
        if(target-nums.get(i)<0) return dp[i][target]= skip;

        int pick=1 + helper(i+1,nums,target-nums.get(i),dp);

        return dp[i][target]= Math.max(pick,skip);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n= nums.size();
        int[][] dp= new int[n][target+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]= -1;
            }
        }
        int ans= helper(0,nums,target,dp);

        if(ans<=0) return -1;
       else  return ans;
    }
}