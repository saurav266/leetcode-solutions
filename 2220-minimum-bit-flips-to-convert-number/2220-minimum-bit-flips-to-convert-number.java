class Solution {
    public int minBitFlips(int start, int goal) {
        int n= start^ goal;
        int count=0;
        for(int i=0;i<32;i++){
            int maask=(1<<i);
            if((n & maask )!=0) count++;
        }
        return count;
    }
}