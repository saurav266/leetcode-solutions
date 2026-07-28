class Solution {
    public int sliding(int[] nums,int k){
        int n= nums.length;
        Map<Integer,Integer> mp= new HashMap<>();
        int count=0;
        int i=0;
        int j=0;
        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

            while(mp.size()>k){
                int freq=mp.get(nums[i]);
                mp.put(nums[i],freq-1);
                // check freq
                if(mp.get(nums[i])==0){
                    mp.remove(nums[i]);
                }
                i++;
            }
            count +=j-i+1;// ending at j;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sliding(nums,k)- sliding(nums,k-1);
    }
}