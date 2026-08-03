class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n= nums.length;
        int[] ans ={-1,-1};
        int lo=0;
        int hi=n-1;
        int fp=-1;
        while(lo<=hi){
            int mid =lo + (hi-lo)/2;

            if(nums[mid]==target){
                if(mid>0 && nums[mid]==nums[mid-1]) hi= mid-1;
                else {
                    fp=mid;
                    break;
                }
            }
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        lo=0;
        hi=n-1;
        int sp=-1;
        while(lo<=hi){
            int mid =lo + (hi-lo)/2;

            if(nums[mid]==target){
                if(mid<n-1 && nums[mid]==nums[mid+1]) lo= mid+1;
                else {
                    sp=mid;
                    break;
                }
            }
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        ans[0]=fp;
        ans[1]=sp;
        return ans;
    }
}