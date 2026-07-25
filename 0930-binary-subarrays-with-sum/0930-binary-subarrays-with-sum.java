class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        Map<Integer,Integer> mp= new HashMap<>();
        int count=0;
        int currSum=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            currSum +=nums[i];
            int rem=currSum- goal;
            if(mp.containsKey(rem)){
                count += mp.get(rem);
            }
            mp.put(currSum,mp.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}