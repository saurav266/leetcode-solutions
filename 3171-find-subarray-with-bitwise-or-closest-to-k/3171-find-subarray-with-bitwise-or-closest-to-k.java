class Solution {
    public int minimumDifference(int[] nums, int k) {
        Set<Integer> prev = new HashSet<>();
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            Set<Integer> cur = new HashSet<>();
            cur.add(num);
            minDiff = Math.min(minDiff, Math.abs(num - k));

            for (int val : prev) {
                int orVal = val | num;
                cur.add(orVal);
                minDiff = Math.min(minDiff, Math.abs(orVal - k));
            }

            prev = cur;
        }

        return minDiff;
    }
}