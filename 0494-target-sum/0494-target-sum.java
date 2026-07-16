class Solution {
    static int sum=0;
    public int helper(int i, int[] nums,int res, int target, int[][] dp){
        if(i==nums.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[i][res+sum]!=-1) return dp[i][res+sum];
        int sub= helper(i+1,nums,res-nums[i],target,dp);

        int add= helper(i+1, nums,res+nums[i], target,dp);

        return dp[i][res+sum]= sub+ add;
    }
    public int findTargetSumWays(int[] nums, int target) {
        sum=0;
        int n= nums.length;
        for(int ele:nums) sum+=ele;
        int[][] dp= new int[n][2*sum +1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        return helper(0,nums,0,target,dp);
    }
}