class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        int[] ans= new int[m];

        for(int i=0;i<m;i++){
            int max=-1;
            for(int j=0;j<n;j++){
                int idx=j;

                if(nums1[i]==nums2[j]){
                    while(idx<n){
                        if(nums2[idx]>nums1[i]){
                            max=nums2[idx];
                            break;

                        }
                        idx++;
                    }
                }
                
            }
            ans[i]=max;
        }
        return ans;
    }
}