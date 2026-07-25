class Solution {
    public int binary(int idx, int k, int[] nums, int[] pref){
        int target= nums[idx];
        int i=0;
        int j=idx;
        int best_idx=idx;
        while(i<=j){
            int mid= i +(j-i)/2;

            int count=(idx-mid+1);
            int windoSum=count*target;

            int currSum=pref[idx]-pref[mid] +nums[mid];

            int ops= windoSum-currSum;

            if(ops>k){
                i=mid+1;
            }
            else{
                best_idx=mid;
                j=mid-1;
            }
        }
        return idx-best_idx +1;
    }
    public int maxFrequency(int[] nums, int k) {
        int n= nums.length;
        Arrays.sort(nums);
        int[] pref= new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]= pref[i-1]+nums[i];
        }
        int res=0;
        for(int target_idx=0; target_idx<n;target_idx++){
            res = Math.max(res,binary(target_idx,k,nums,pref));
        }
        return res;
    }
}