class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n= nums.length;
        int minIdx=-1;
        int maxIdx=-1;
        int culpIdx=-1;
        long ans=0;

        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]> maxK){
                culpIdx=i;
            }

            if(nums[i]==minK){
                minIdx=i;
            }

            if(nums[i]==maxK){
                maxIdx=i;
            }

            long smaller=Math.min(minIdx,maxIdx);
            long temp=smaller-culpIdx;
            ans +=(temp<=0) ? 0: temp;

        }
        return ans;
    }
}