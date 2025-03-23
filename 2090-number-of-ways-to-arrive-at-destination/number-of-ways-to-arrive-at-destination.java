class Solution {
    private int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        int sz = roads.length;
        int cnt[] = new int[n];
        long ans = 0;
        long minTime[] = new long[n];
        Map<Integer, List<Pair<Integer, Long>>> mp = new HashMap<>();
        PriorityQueue<Pair<Integer, Long>> q = new PriorityQueue<>((a, b) -> (int) (a.getValue() - b.getValue()));

        Arrays.fill(minTime, Long.MAX_VALUE);
        Arrays.fill(cnt, 0);

        for(int i=0; i<n; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int i=0; i<sz; i++){
            mp.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2] * 1L));
            mp.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2] * 1L));
        }

        minTime[0] = 0; cnt[0] = 1;
        q.add(new Pair(0, 0L));
        while(!q.isEmpty()){
            int curr = q.peek().getKey();
            long currTime = q.poll().getValue();

            if(currTime > minTime[curr]) continue;

            for(Pair<Integer, Long> p : mp.get(curr)){
                if(minTime[p.getKey()] > (currTime + p.getValue())){
                    cnt[p.getKey()] = cnt[curr];
                    minTime[p.getKey()] = (currTime + p.getValue());
                    q.add(new Pair(p.getKey(), minTime[p.getKey()]));
                }
                else if(minTime[p.getKey()] == (currTime + p.getValue())){
                    cnt[p.getKey()] = (cnt[p.getKey()] + cnt[curr]) % MOD;
                }
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.print(minTime[i] + ", ");
        // }
        // System.out.println();
        // for(int i=0; i<n; i++){
        //     System.out.print(cnt[i] + ", ");
        // }

        return cnt[n-1];
    }
}