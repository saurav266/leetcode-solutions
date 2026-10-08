class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int n= nums.length;
        int m= q.length;
        int sum=0;
        for(int num: nums){
            if(num%2==0){
                sum +=num;
            }
        }
        int[] ans= new int[m];
        int k=0;
        for(int i=0;i<m;i++){
            int idx=q[i][1];
            int val=q[i][0];
            int num=nums[idx];
            if(num%2==0) sum -=num;
            num +=val;
            if(num%2==0) {
                sum +=num;
                
            }
            nums[idx]=num;
            ans[k++]= sum;
        }
        return ans;
    }
}