class Solution {

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i <= n - k; i++) {

            Set<Integer> set = new HashSet<>();

           
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            
            for (int x : set) {
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}