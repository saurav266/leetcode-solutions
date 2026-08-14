class Solution {
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        int m= w.length;
        int n=p.length;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> b[0]-a[0]);

        for(int i=0;i<n;i++){
            pq.offer(new int[]{p[i],d[i]});
        }
        Arrays.sort(w);
        for (int i = 0; i < m / 2; i++) {
            int temp = w[i];
            w[i] = w[m - 1 - i];
            w[m - 1 - i] = temp;
        }

        int totalProfit=0;

        int i=0;
        while(i<m && !pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek()[1]> w[i]){
                pq.poll();
            }
            if(!pq.isEmpty()){
                totalProfit +=pq.peek()[0];
            }
            i++;
        }
        return totalProfit;
    }
}