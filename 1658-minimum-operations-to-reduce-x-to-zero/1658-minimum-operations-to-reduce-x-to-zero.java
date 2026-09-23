class Solution {
    public int minOperations(int[] nums, int x) {
        int n= nums.length;
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            mp.put(sum,i);
        }
        if(sum<x) return -1;
        int rem=sum-x;
        int longest=Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            int find=sum-rem;
            if(mp.containsKey(find)){
                int idx= mp.get(find);
                longest= Math.max(longest,i-idx);
            }
        }
        return longest==Integer.MIN_VALUE ?-1:(n-longest);
    }

}