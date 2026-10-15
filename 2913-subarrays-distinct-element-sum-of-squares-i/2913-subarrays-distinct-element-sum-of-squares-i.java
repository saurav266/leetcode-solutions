class Solution {
    public int sumCounts(List<Integer> nums) {
        int total=0;
        int n= nums.size();
        for(int i=0;i<n;i++){
            Set<Integer> set= new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                int s=set.size();
                total += s*s;
            }
        }
        return total;
    }
}