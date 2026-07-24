class Solution {
    public int longestSubarray(int[] nums) {
        int n= nums.length;
        int res=0;
        int i=0;
        int j=0;
        int countZero=0;
        while(j<n){
            if(nums[j]==0) countZero++;

            while(countZero>1){
                if(nums[i]==0){
                    countZero--;
                }
                i++;
            }
            res= Math.max(res,j-i);
            j++;
        }
        return res;
    }
}