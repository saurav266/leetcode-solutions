class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n= nums.length;
        int maxEle=0;
        for(int ele: nums){
            maxEle=Math.max(ele,maxEle);
        }
        long count=0;
        int i=0;
        int j=0;
        int countMax=0;
        while(j<n){
            if(nums[j]==maxEle){
                countMax++;
            }
            while(countMax==k){
                count +=1+ n-1 -j;
                if(nums[i]==maxEle){
                    countMax--;
                }
                i++;
            }
            j++;
        }
        return count;
    }
}