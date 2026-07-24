class Solution {
    public int singleNumber(int[] nums) {
        int n= nums.length;
        int xor=0;
        for(int ele :nums){
            xor=xor^ele;
        }
        return xor;
    }
}