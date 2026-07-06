class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return a[0] - b[0];
            return b[1] -a[1];
        });

        int[] curr= intervals[0];
        int count=0;

        for(int i=1;i<intervals.length;i++){
            int[] next= intervals[i];

            if(next[0]>=curr[0] && next[1]<=curr[1]){
                continue;
            }
            else{
                count++;
                curr=next;
            }
        }
        return count+1;
    }
}