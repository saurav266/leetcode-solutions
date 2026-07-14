class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == false) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i] == false)
                count++;
        }
        return count;
    }
}