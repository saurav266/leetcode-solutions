class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        int n=nums.length;
        Arrays.sort(nums);
        int left=0;
        int right=nums[n-1]-nums[0];
       
        int res=right;
        while(left<=right){
            int mid = left + (right-left)/2;
            int pairs=0;

            for(int i=1;i<n;i++){
                if(nums[i]- nums[i-1]<=mid){
                    pairs++;
                    i++;
                }
            }

            if(pairs>=p){
                res =mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        return res;

    }
}