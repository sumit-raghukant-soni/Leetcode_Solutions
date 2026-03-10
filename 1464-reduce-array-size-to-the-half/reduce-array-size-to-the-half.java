class Solution {
    public int minSetSize(int[] arr) {
        int freq[] = new int[100001], sz = arr.length, target = sz/2, ans = 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>( 
            (a, b) -> b.getValue() - a.getValue()
        );

        for(int i : arr) freq[i]++;

        for(int i=0; i<100001; i++){
            if(freq[i] > 0) pq.add(new Pair(i, freq[i]));
        }

        while(sz > target){
            int cnt = pq.poll().getValue();
            sz -= cnt;
            ans++;
        }

        return ans;
    }
}