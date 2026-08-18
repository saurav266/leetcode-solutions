class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> vis= new HashSet<>();
        Set<String> b= new HashSet<>();
        for(String s: bank){
            b.add(s);
        }
        Queue<String> q= new LinkedList<>();
        vis.add(startGene);
        q.add(startGene);
        int steps = 0;
        char[] genes = {'A','C','G','T'};
        while(!q.isEmpty()){
            int n= q.size();
            for(int i=0;i<n;i++){
                String curr= q.poll();
                if(curr.equals(endGene)) return steps;
                char[] arr=curr.toCharArray();
                for(int pos=0;pos<arr.length;pos++){
                    char old=arr[pos];
                    for(char g : genes){
                        if(g==old) continue;
                        arr[pos]=g;
                        String next= new String(arr);
                        if(b.contains(next) && !vis.contains(next)){
                            vis.add(next);
                            q.add(next);
                        }
                    }
                    arr[pos]=old;
                }
            }
            
            steps++;
        }
        return -1;
    }
}