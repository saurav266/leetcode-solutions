class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = (long) totalTrips * getMin(time); // upper bound
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canComplete(time, mid, totalTrips)) {
                ans = mid;
                right = mid - 1; // try smaller time
            } else {
                left = mid + 1; // need more time
            }
        }
        return ans;
    }

    private boolean canComplete(int[] time, long mid, int totalTrips) {
        long trips = 0;
        for (int t : time) {
            trips += mid / t;
            if (trips >= totalTrips) return true; // early exit
        }
        return trips >= totalTrips;
    }

    private int getMin(int[] time) {
        int min = Integer.MAX_VALUE;
        for (int t : time) {
            min = Math.min(min, t);
        }
        return min;
    }
}
