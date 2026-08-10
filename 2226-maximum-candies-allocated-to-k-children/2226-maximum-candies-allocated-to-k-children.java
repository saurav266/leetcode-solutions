class Solution {
    public boolean canAllocated(int[] candies, long k, int mid){
        long total=0;
        for(int c: candies){
            total +=c/mid;

            if(total>= k) return true;
        }
        return total >=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int n= candies.length;
        int left=1;
        int right=Arrays.stream(candies).max().getAsInt();
        int res=0;
        while(left<=right){
            int mid = left + (right-left)/2;

            // check 
            if(canAllocated(candies,k,mid)){
                res= mid;
                left =mid+1;
            }
            else{
                right=mid-1;
            }


        }
        return res;
    }
}