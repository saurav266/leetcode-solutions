class Solution {
    public boolean canPut(int[] position, int m, int d){
        int n=position.length;
        int count=1;
        int last=position[0];
        for(int i=0;i<n;i++){
            if(position[i]-last>=d){
                count++;
                last=position[i];
                if(count>=m) return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int left=1;
        int right=position[n-1]-position[0];
        int ans=0;
        while(left<=right){
            int mid =left + (right -left)/2;
            if(canPut(position,m,mid)){
                ans= mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}