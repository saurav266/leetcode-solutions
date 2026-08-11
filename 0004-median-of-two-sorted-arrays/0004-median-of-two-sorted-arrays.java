class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] hel=new int[nums1.length +nums2.length];
        for(int i=0;i<nums1.length;i++){
            hel[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            hel[i+nums1.length]=nums2[i];
        }
        Arrays.sort(hel);
        double ans=0;
        int n=hel.length;
        if(n%2==0){
            ans=(hel[n/2-1]+ hel[n/2])/2.0;
        }
        else ans=hel[n/2];
        return ans;
    }
}