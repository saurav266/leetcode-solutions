class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList<>();
        Map<Character,Integer> mp= new HashMap<>();
        for(char ch:p.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int i=0;
        int j=0;
        int n=s.length();
        int k=p.length();
        while(j<n){
            char ch= s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
            }

            if(j-i+1==k){
                // check all freq zero
                boolean valid=true;

                for(int val : mp.values()){
                    if(val!=0){
                        valid=false;
                        break;
                    }
                }

                if(valid){
                    ans.add(i);
                }

                char left= s.charAt(i);

                if(mp.containsKey(left)){
                    mp.put(left,mp.get(left)+1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}