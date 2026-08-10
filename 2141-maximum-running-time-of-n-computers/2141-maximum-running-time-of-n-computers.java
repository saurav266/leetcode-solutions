class Solution {
    public boolean canRun(int n, int[] b, long time){
        long sum=0;
        for(int i=0;i<b.length;i++){
            if(b[i]>= time){
                n--;
            }
            else{
                sum +=b[i];
            }
            if(sum >=(int) n* time){
                return true;
            }
        }
        return false;
    }
    public long maxRunTime(int n, int[] b) {
        long sum=0;
        long max=0;
        long min=Long.MAX_VALUE;
        for(int i=0;i<b.length;i++){
            sum +=b[i];
            max= Math.max(max,b[i]);
            min=Math.min(min,b[i]);
        }

        long left=min;
        long right=sum/n;
        long res=0;
        while(left<=right){
            long mid = left + (right-left)/2;

            // check can run all computer
            if(canRun(n,b, mid)){
                res= mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;
    }
}