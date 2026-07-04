class Solution {
    public int[] answerQueries(int[] nums, int[] q) {
        int n= nums.length;
        int m=q.length;
        int[] ans= new int[m];
        Arrays.sort(nums);

        for(int i=1;i<n;i++){
            nums[i] +=nums[i-1];
        }

        for(int i=0;i<m;i++){
            int len=0;
            for(int j=0;j<n;j++){
                if(nums[j]>q[i]) break;
                len++;
            }
            ans[i]=len;

        }
        return ans;
    }
}