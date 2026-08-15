class Solution {
    public int lowerBond(int[] nums, int t, int lo, int hi){
        int res=hi+1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>=t){
                res= mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return res;
    }

    public int upperBond(int[] nums, int t, int lo, int hi){
        int res=hi+1;
        while(lo<=hi){
            int mid= lo + (hi-lo)/2;

            if(nums[mid]>t){
                res=mid;
                hi=mid-1;
            }
            else{
                lo= mid+1;
            }
        }
        return res;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n= nums.length;
        long count=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int left = lowerBond(nums,lower-nums[i],i+1,n-1);
            int right= upperBond(nums,upper-nums[i],i+1,n-1);
            count += (right-left);
        }
        return count;
    }
}