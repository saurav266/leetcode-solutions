class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n=s.length();
        int zero=0;
        int one=0;
        int total=0;
        int i=0;
        int j=0;
        while(j<n){
            if(s.charAt(j)=='1') one++;
            else{
                zero++;
            }

            while(zero>k && one>k){
                if(s.charAt(i)=='1') one --;
                else zero--;
                i++;
            }
            total +=j-i+1;
            j++;
        }
        return total;
    }
}