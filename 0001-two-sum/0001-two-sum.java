class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        int[] ans= new int[2];
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++){
            int rem=target-nums[i];
            if(mp.containsKey(rem)){
                ans[0]=i;
                ans[1]=mp.get(rem);
                break;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }
}