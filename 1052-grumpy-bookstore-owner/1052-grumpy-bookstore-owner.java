class Solution {
    public int maxSatisfied(int[] c, int[] g, int m) {
        int n=c.length;
        int maxUnS=0;
        // intional staisfied
        int currUnS=0;
        for(int i=0;i<m;i++){
            currUnS +=c[i]*g[i];
        }
        maxUnS=currUnS;
        int i=0;
        int j=m;
        while(j<n){
            currUnS +=c[j]*g[j];
            currUnS -=c[i]*g[i];

            maxUnS=Math.max(maxUnS,currUnS);
            i++;
            j++;
        }
        int total= maxUnS;
        for( i=0;i<n;i++){
            total +=c[i]*(1-g[i]);
        }
        return total;
    }
}