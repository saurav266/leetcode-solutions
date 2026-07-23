class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n= nums.length;
        int[] ans= new int[n];
        Arrays.fill(ans, -1);
        int i=0;
        int j=0;
        long sum=0;
        while(j<n){
            sum +=nums[j];

            if(j-i+1==(2*k+1)){
                int avg=(int)(sum/(2*k+1));
                ans[j-k]=avg;
                sum -=nums[i];
                i++;
            }
            
            j++;
        }
        return ans;
    }
}