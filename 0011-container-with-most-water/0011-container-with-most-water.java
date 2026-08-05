class Solution {
    public int maxArea(int[] h) {
        int n= h.length;
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=n-1;
        while(i<j){
            int total=Math.min(h[i],h[j]) * (j-i);
            max=Math.max(max,total);
            if(h[i]<h[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}