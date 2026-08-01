class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int[] ans= new int[n-k+1];
        Arrays.fill(ans,-1);
        Deque<Integer> dq= new LinkedList<>();
        int i=0;
        for(int j=0;j<n;j++){
            if(dq.size()==k){
                dq.pollFirst();
            }

            if(!dq.isEmpty() && dq.peekLast()!=nums[j]-1){
                dq.clear();
            }

            dq.offerLast(nums[j]);
            if(j>=k-1){
                if(dq.size()==k){
                    ans[i++]=dq.peekLast();
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }
}