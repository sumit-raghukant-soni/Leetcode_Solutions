class Solution {
    public int maxEvents(int[][] events) {
        int sz = events.length, cnt = 0;
        int vis[] = new int[100001];

        Arrays.sort(events, (a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            return b[0] - a[0];
        });

        for(int i=0; i<sz; i++){
            int u = events[i][0], v = events[i][1];
            // System.out.println(u + ":" + v);
            while(v >= u && vis[v] != 0) v--;
            if(v >= u) vis[v] = 1;
        }

        for(int i=0; i<100001; i++){
            if(vis[i] == 1) cnt++;
        }

        return cnt;
    }
}