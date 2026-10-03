class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Set<List<Integer>> st= new HashSet<>();
       Arrays.sort(nums);
       int n= nums.length;
       for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                List<Integer> temp= new ArrayList<>();
                int total=nums[i] + nums[j]+ nums[k];
                if(total==0){
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    st.add(temp);
                    j++;
                }
                else if(total> 0){
                    k--;
                }
                else{
                    j++;
                }
            }
       }
       return new ArrayList<>(st);

    }
}