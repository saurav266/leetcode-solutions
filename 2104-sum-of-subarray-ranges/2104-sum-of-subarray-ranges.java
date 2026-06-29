class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;

        // Contribution as maximum
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int idx = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                ans += (long) nums[idx] * (idx - left) * (i - idx);
            }
            st.push(i);
        }

        // Contribution as minimum
        st.clear();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int idx = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                ans -= (long) nums[idx] * (idx - left) * (i - idx);
            }
            st.push(i);
        }

        return ans;
    }
}
