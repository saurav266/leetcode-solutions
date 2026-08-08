class Solution {
    public int getMax(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int p:piles){
            max=Math.max(p,max);
        }
        return max;
    }
    public boolean complete(int[] piles, int speed, int h){
        long hour=0;

        for(int p:piles){
            hour +=(p+speed-1)/speed;

            if(hour>h)  return false ; // nhi kar skata finsih
        }
        return hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=getMax(piles);
        int ans=hi;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(complete(piles,mid,h)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}