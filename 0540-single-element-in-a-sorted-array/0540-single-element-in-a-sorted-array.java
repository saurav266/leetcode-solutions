class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        int lo=0;
        int hi=n-1;
        while(lo<hi){
            int mid =lo + (hi-lo)/2;
            boolean isEven= (hi-mid)%2==0;

            if(nums[mid]==nums[mid+1]){
                if(isEven){
                    lo=mid+2;
                }
                else{
                    hi=mid-1;
                }
            }
            else{
                if(isEven){
                    hi=mid;
                }
                else{
                    lo=mid+1;
                }
            }
        }
        return nums[hi];
    }
}