class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n= nums.length;
        int minDiff=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;

            while(j<k){
                int total= nums[i]+nums[j]+ nums[k];
                int diff=Math.abs(target-total);

                if(minDiff>diff){
                    minDiff=diff;
                    sum=total;
                }
                if(total>target){
                    k--;
                }
                else j++;
            }
        }
        return sum;
    }

}