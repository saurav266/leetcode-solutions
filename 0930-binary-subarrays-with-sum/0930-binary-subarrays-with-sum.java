class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n= nums.length;
        int count=0;
        int currSum=0;
        int i=0;
        int j=0;
        int countZero=0;
        while(j<n){
            currSum +=nums[j];

            while(i<j && (nums[i]==0 || currSum > goal)){
                if(nums[i]==0){
                    countZero++;
                }
                else {
                    countZero =0;
                }
                currSum -=nums[i];
                i++;
            }

            if(currSum==goal){
                count +=1 + countZero;
            }
            j++;
        }
        return count;
    }
}