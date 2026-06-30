class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()==3){
                count=count+(n-i);
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
        }
        return count;
    }
}