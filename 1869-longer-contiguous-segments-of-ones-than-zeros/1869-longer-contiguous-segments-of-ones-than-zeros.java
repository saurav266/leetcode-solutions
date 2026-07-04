class Solution {
    public boolean checkZeroOnes(String s) {
        int oneCount=0;
        int count=0;
        for(char ch: s.toCharArray()){
            if(ch=='1'){
                count++;
                oneCount=Math.max(count,oneCount);

            }
            else{
                count=0;
            }
        }
        count=0;
        int zeroCount=0;
        for(char ch : s.toCharArray()){
            
            if(ch=='0'){
                count++;
                zeroCount=Math.max(count,zeroCount);
            }
            else{
                count=0;
            }
        }
        return oneCount>zeroCount;
    }
}