class Solution {
    public int maximumProduct(int[] nums) {
        int n= nums.length;
        long ans=1;
        if(n==3){
            for(int i=0;i<n;i++){
                ans *=nums[i];
            }
            return (int)ans;
        }
        Arrays.sort(nums);
        long right=nums[n-3]* nums[n-2] * nums[n-1];

        long left=( nums[0] * nums[1] * nums[n-1]);

        return (int)(Math.max(right,left));
    }
}