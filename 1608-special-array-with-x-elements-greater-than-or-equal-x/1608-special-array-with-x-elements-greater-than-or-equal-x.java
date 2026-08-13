class Solution {
    public int binarySearch(int[] nums, int t){
        int n= nums.length;
        int lo=0;
        int hi=n-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]<t){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return n-lo;
    }
    public int specialArray(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        for(int x=0;x<=n;x++){
            int count=binarySearch(nums,x);
            if(count==x) return x;
        }

        return -1;
    }
}