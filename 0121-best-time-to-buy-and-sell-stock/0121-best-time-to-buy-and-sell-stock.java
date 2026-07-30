class Solution {
    public int maxProfit(int[] nums) {
        int n= nums.length;
        int maxPro=0;
        int price=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            price=Math.min(price,nums[i]);
            maxPro=Math.max(maxPro,nums[i]-price);
        }
        return maxPro;
    }
}