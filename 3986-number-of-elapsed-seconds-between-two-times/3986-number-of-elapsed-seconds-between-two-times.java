class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int totalSec = 0;
        int hour1 = Integer.parseInt(startTime.substring(0,2));
        int hour2 = Integer.parseInt(endTime.substring(0,2));

        int min1 = Integer.parseInt(startTime.substring(3,5));
        int min2 = Integer.parseInt(endTime.substring(3,5));

        int sec1 = Integer.parseInt(startTime.substring(6));
        int sec2 = Integer.parseInt(endTime.substring(6));

        int stTime = (hour1*3600) + (min1*60) + sec1;
        int eTime = (hour2*3600) + (min2*60) + sec2;

        totalSec = eTime - stTime;
        return totalSec;

    }
}