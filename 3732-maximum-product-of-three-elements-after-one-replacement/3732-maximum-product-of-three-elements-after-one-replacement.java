class Solution {
    public long maxProduct(int[] nums) {
        int n= nums.length;
        long ans=1;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                nums[i]=- nums[i];
            }
        }
        Arrays.sort(nums);
        long right=(long)nums[n-1]* nums[n-2] * 100000;

        return right;
    }
}