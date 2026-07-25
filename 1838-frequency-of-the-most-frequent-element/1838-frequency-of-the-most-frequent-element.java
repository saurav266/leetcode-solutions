class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;

        int res=0;

        int i=0;
        long currSum=0;
        for(int j=0;j<n;j++){
            long target=nums[j];

            currSum +=nums[j];

            if((j-i+1)* target-currSum >k){
                currSum -=nums[i];
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}