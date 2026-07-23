class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        Set<Character> st= new HashSet<>();
        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');
        
        int ans=Integer.MIN_VALUE;

        int i=0;
        int j=0;
         int count=0;
        while(j<n){
           
            char ch=s.charAt(j);
            if(st.contains(ch)){
                count++;
            }

            if(j-i+1==k){
                ans=Math.max(count,ans);
                if(st.contains(s.charAt(i))){
                    count--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}