class Solution {
    public int minMoves(int[] nums) {
         int totalSum=0;
       int min=Integer.MAX_VALUE;
       for(int num:nums){
        min=Math.min(min,num);
        totalSum+=num;
       }
       int n=nums.length;
       return totalSum-n*min;
    }
}