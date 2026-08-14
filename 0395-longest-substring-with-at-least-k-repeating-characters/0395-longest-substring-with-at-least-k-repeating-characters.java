class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int start = 0; start < n; start++) {
            Map<Character, Integer> freqMap = new HashMap<>();
            int unique = 0;
            int countAtLeastK = 0;

            for (int end = start; end < n; end++) {
                char ch = s.charAt(end);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

                if (freqMap.get(ch) == 1) unique++;
                if (freqMap.get(ch) == k) countAtLeastK++;

                if (unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }
}