class Solution {
    public int binarySearch(int[][] items, int t){
        int n= items.length;
        int left=0; 
        int right=n-1;
        int res=-1;
        while(left<=right){
            int mid = left + (right-left)/2;

            if(items[mid][0]<=t){
                res= mid;
                left =mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return res;

    }
    public int[] maximumBeauty(int[][] items, int[] q) {
        Arrays.sort(items,(a,b)-> Integer.compare(a[0],b[0]));
        int n= items.length;
        int[] prefixMax= new int[n];
        prefixMax[0]=items[0][1];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],items[i][1]);
        }
        int m=q.length;
        int[] ans= new int[m];

        for(int i=0;i<m;i++){
            int idx=binarySearch(items,q[i]);
            ans[i]=(idx==-1) ? 0 : prefixMax[idx];
        }
        return ans;
    }
}