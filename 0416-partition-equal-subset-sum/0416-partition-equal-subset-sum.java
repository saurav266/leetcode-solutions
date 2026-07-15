class Solution {
    public boolean helper(int i,int[] nums, int target, int[][] dp){

        if(i==nums.length){
            if(target==0) return true;
            else return false;
        }
        if(dp[i][target]!=-1){
            if(dp[i][target]==1) return true;
            else return false;
        }
        boolean ans=false;
        boolean skip=helper(i+1,nums,target,dp);
        if(target-nums[i]<0){
            ans=skip;
        }
       else{
         boolean pick= helper(i+1, nums,target-nums[i],dp);
         ans= pick || skip;
       }

        if(ans==true) dp[i][target]=1;
        else dp[i][target]=0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int n= nums.length;

        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
        }
        int target= sum/2;
        if(sum%2!=0) return false;
        int[][] dp= new int[n][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,nums, target,dp);
    }
}