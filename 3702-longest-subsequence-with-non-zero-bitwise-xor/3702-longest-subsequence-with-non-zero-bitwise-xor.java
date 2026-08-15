class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean b = false;
        for(int num : nums) {
            ans ^= num;
            if(num != 0) b = true;
        }
        if(ans != 0) return n;
        return b ? n - 1 : 0;
    }
}