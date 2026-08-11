class Solution {
    public int lowerBond(int[] startTime, int time){
        int lo=0;
        int hi=startTime.length;

        while(lo<hi){
            int mid =lo + (hi-lo)/2;
            if(startTime[mid]<=time) lo=mid+1;
            else{
                hi=mid;
            }
        }
        return lo;
    }
    public int upperBond(int[] endTime, int time){
        int lo=0;
        int hi=endTime.length;

        while(lo<hi){
            int mid =lo + (hi-lo)/2;
            if(endTime[mid]<time) lo=mid+1;
            else{
                hi=mid;
            }
        }
        return lo;
    }
    public int[] fullBloomFlowers(int[][] f, int[] p) {
        int m= f.length;
        int n=p.length;

        int[] ans= new int[n];

        int[] startTime= new int[m];
        int[] endTime= new int[m];

        for(int i=0;i<m;i++){
            startTime[i]= f[i][0];
            endTime[i]= f[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);
        
        for(int i=0;i<n;i++){
            int time= p[i];

            int started=lowerBond(startTime,time);
            int ended=upperBond(endTime,time);
            int total=started-ended;
            ans[i]=total;
        }
       
        return ans;
    }
}