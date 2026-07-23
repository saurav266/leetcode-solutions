class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n= nums.length;

        int i=0;
        int j=0;
        int count=0;
        int ans=0;
        int prefix=0;
        while(j<n){
            if(nums[j]%2!=0){
                count++;
                prefix=0;
            }

            while(count==k){
               
                if(nums[i]%2!=0){
                    count--;
                }
                prefix++;
                i++;
            }
            ans +=prefix;
            j++;
        }
        return ans;
    }
}