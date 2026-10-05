class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans= new ArrayList<>();
        Map<String,List<String>> mp= new HashMap<>();

        for(String s: strs){
            char[] ch= s.toCharArray();
            Arrays.sort(ch);
            String temp= new String(ch);
            if(!mp.containsKey(temp)){
                mp.put(temp,new ArrayList<>());
            }
            mp.get(temp).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}