class Solution {
    public boolean canMake(int[] bloomDay, int m, int k, int day){
        int bouquets = 0, flowers = 0;

        for(int bloom: bloomDay){
            if(bloom<=day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }
            else{
                flowers=0;
            }
            if (bouquets >= m) return true;
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n= bloomDay.length;
        if((long)m*k>n) return -1;

        int minDay=Integer.MAX_VALUE;
        int maxDay=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            minDay=Math.min(minDay,bloomDay[i]);
            maxDay=Math.max(maxDay,bloomDay[i]);
        }

        int ans=-1;
        int left=minDay;
        int right=maxDay;

        while(left<=right){
            int mid=left + (right-left)/2;

            if(canMake(bloomDay,m,k,mid)){
                ans= mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}