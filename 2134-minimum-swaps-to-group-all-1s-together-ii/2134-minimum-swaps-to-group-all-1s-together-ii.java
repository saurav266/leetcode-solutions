class Solution {
    public int minSwaps(int[] nums) {
        int n= nums.length;
        int[] res= new int[2*n];
        for(int i=0;i<2*n;i++){
            res[i]=nums[i%n];
        }
        int totalOne=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                totalOne++;
            }
        }
        int i=0;
        int j=0;
        int min=0;
        int currOne=0;

        while(j<2*n){
            if(res[j]==1){
                currOne++;
            }

            if(j-i+1 > totalOne){
                currOne -=res[i];
                i++;
            }

            min=Math.max(min,currOne);
            j++;
        }
        return totalOne-min;


    }
}