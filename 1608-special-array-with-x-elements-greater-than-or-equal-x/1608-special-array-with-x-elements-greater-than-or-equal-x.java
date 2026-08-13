class Solution {
    public int specialArray(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int x= n-i;

            if(nums[i]>=x){

                if(i==0|| nums[i-1]<x) return x;
            }
        }
        return -1;
    }
}