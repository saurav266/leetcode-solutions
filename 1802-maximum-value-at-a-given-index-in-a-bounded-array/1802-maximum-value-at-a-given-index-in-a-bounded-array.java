class Solution {
    private long getSum(long count , long val){
        return count*val - (count *(count+1)/2);
    }
    public int maxValue(int n, int index, int maxSum) {
        long left=1;
        long right=maxSum;
        int res=0;
        while(left<=right){
            long mid=left + (right-left)/2;

            long leftCount=Math.min((long) index, mid-1);

            long leftSum=getSum(leftCount,mid);
            leftSum +=Math.max(0L ,index-mid+1);

            long rightCount=Math.min((long)n-index-1, mid-1);
            long rightSum=getSum(rightCount,mid);

            rightSum +=Math.max(0L,(long) n-index-1-mid+1);

            long total=leftSum + rightSum + mid;


            if(total<=maxSum){
                res=(int)Math.max(res,mid);
                left =mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;
    }
}