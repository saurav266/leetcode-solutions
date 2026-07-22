class Solution {
    public String minWindow(String s, String t) {
       if (s.length() < t.length()) return "";
       int m=s.length();
       int n=t.length();
       Map<Character,Integer> mp= new HashMap<>();
       for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
       int minLen = Integer.MAX_VALUE;
       int countR=n;
       int start = 0;
       int i=0;
       int j=0;
       while(j<m){
          char ch=s.charAt(j);
          if(mp.containsKey(ch)){
              int freq= mp.get(ch);
                if(freq>0){
                
                    countR--;
                }
             mp.put(ch,mp.get(ch)-1);

            }

            while(countR==0){
                if(j-i+1<minLen){
                    minLen=j-i+1;
                    start=i;
                }

                char left=s.charAt(i);
                if(mp.containsKey(left)){
                    mp.put(left,mp.get(left)+1);
                    if(mp.get(left)>0){
                        countR++;
                    }
                }
                i++;
            }
            j++;
       }
       return minLen==Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}