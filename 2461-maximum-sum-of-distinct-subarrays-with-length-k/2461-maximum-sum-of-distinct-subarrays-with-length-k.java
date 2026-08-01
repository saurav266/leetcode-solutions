class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n= nums.length;
        Set<Integer> st= new HashSet<>();
        int i=0;
        int j=0;
        long maxSum=0;
        long sum=0;

        while(j<n){
            sum +=nums[j];

            while(st.contains(nums[j])){
                sum -=nums[i];
                st.remove(nums[i]);
                i++;
            }

            st.add(nums[j]);
            if(st.size()==k){
                maxSum=Math.max(maxSum,sum);

                sum -=nums[i];
                st.remove(nums[i]);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}