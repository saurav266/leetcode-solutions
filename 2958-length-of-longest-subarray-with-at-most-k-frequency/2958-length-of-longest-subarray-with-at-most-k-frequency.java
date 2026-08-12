class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n= nums.length;
        int ans=-1;
        int i=0;
        int j=0;
        Map<Integer,Integer> mp= new HashMap<>();
        while(j<n){
            int key= nums[j];
            mp.put(key,mp.getOrDefault(key,0)+1);

            while(mp.get(key)>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                i++;
            }
            ans= Math.max(ans,j-i+1);
            j++;

        }
        return ans;
    }
}