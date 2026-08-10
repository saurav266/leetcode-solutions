class Solution {
    public boolean canTrip(int[] time, int totalTrips, long target){
        long trip=0;

        for(int t: time){
            trip +=target/t;

            if(trip>=totalTrips) return true;
        }
        return trip >= totalTrips;
    }
    private int getMin(int[] time) {
        int min = Integer.MAX_VALUE;
        for (int t : time) {
            min = Math.min(min, t);
        }
        return min;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n=time.length;
        long left=1;
        long right=(long)totalTrips * getMin(time);
        long res=0;

        while(left<=right){
            long mid = left + (right-left)/2;

            if(canTrip(time,totalTrips,mid)){
                res= mid;
                right =mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return res;
    }
}