class Solution {
    public int[] twoSum(int[] num, int target) {
        int n= num.length;
        int i=0;
        int j=n-1;
        int[] ans= new int[2];
        while(i<j){
            if(num[i]+num[j]==target){
                ans[0]=i+1;
                ans[1]=j+1;
            }
            if(num[i]+num[j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}