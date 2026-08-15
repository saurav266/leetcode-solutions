class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n= colors.length;
        int[] temp = new int[n+k-1];
        for(int i=0;i<temp.length;i++){
            temp[i]= colors[i%n];

        }
        int count=0;
        int i=0;
        for(int j=1;j<temp.length;j++){
            if(temp[j]==temp[j-1]){
                i=j;
                continue;
            }

            while(j-i+1>k){
                i++;
            }
            if(j-i+1==k){
                count++;
                i++;
            }
        }
        return count;
    }
}