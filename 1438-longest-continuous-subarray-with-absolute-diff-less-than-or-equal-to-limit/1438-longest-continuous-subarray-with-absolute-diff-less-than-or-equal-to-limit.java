class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n= nums.length;
        PriorityQueue<int[]> max= new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int i=0;
        int j=0;
        int maxLen=0;
        while(j<n){
            max.offer(new int[]{nums[j],j});
            min.offer(new int[]{nums[j],j});

            while(max.peek()[0]-min.peek()[0]>limit){
                i= Math.min(max.peek()[1],min.peek()[1])+1;

                while(max.peek()[1]<i){
                    max.poll();
                }
                while(min.peek()[1]<i){
                    min.poll();
                }
            }
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}