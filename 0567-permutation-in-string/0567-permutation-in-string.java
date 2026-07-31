class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n> m) return false;
        Map<Character,Integer> s1mp= new HashMap<>();
        Map<Character,Integer> windowMap=new HashMap<>();
        for(char ch: s1.toCharArray()){
            s1mp.put(ch,s1mp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch= s2.charAt(i);
            windowMap.put(ch,windowMap.getOrDefault(ch,0)+1);


        }
        if(s1mp.equals(windowMap)) return true;

        for(int i=n;i<m;i++){
            char add=s2.charAt(i);
            char remove=s2.charAt(i-n);

            windowMap.put(add,windowMap.getOrDefault(add,0)+1);

            if(windowMap.get(remove)==1){
                windowMap.remove(remove);
            }
            else{
                windowMap.put(remove,windowMap.get(remove)-1);
            }
            if(s1mp.equals(windowMap)) return true;
        }
        return false;
    }
}