class Solution {
    public int[] findOriginalArray(int[] c) {
        int n=c.length;
        if(n%2!=0) return new int[0];
        int[] ans= new int[n/2];
        int k=0;
        Map<Integer,Integer> mp= new HashMap<>();
        Arrays.sort(c);
        for(int i=0;i<n;i++){
            mp.put(c[i],mp.getOrDefault(c[i],0)+1);
        }

        for(int i=0;i<n;i++){
            int key= c[i];
            if(mp.containsKey(key)){
                if(mp.containsKey(key*2)){
                    ans[k++]=key;

                    mp.put(key,mp.get(key)-1);
                    mp.put(key*2,mp.get(key*2)-1);


                    if(mp.get(key)<=0) mp.remove(key);
                    if(mp.containsKey(key*2) && mp.get(key*2)<=0) mp.remove(key*2);
                }
                else return new int[0];
            }
        }
        return ans;
    }
}