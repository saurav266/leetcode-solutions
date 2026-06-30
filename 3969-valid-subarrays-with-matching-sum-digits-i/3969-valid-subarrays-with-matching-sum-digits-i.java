class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        int count = 0;
        
        // Check all subarrays
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                long sum = prefix[r + 1] - prefix[l];
                
                // Last digit check
                if (sum % 10 != x) continue;
                
                // First digit check
                long first = sum;
                while (first >= 10) {
                    first /= 10;
                }
                
                if (first == x) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
