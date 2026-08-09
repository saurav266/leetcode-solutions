class Solution {
    public long getCost(int[] nums, int[] cost, int t) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res += (long) Math.abs(t - nums[i]) * cost[i];
        }
        return res;
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // find min and max in nums
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        long ans = Long.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long currCost = getCost(nums, cost, mid);
            long nextCost = getCost(nums, cost, mid + 1);

            ans = Math.min(ans, currCost);

            if (currCost <= nextCost) {
                // best is at mid or left side
                right = mid - 1;
            } else {
                // best is at mid+1 or right side
                left = mid + 1;
            }
        }

        return ans;
    }
}
