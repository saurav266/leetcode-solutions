class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int ans=0;
        while(left<right){
            ans +=nums[right]-nums[left];
            left++;
            right--;
        }
        return ans;
    }
}