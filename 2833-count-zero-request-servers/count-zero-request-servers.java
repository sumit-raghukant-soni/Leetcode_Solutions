class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] q) {
        int sz1 = logs.length, sz2 = q.length, fq[] = new int[100001];
        int ans[] = new int[sz2], q2[] = new int[sz2], cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz2; i++){
            q2[i] = q[i];
        }

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        Arrays.sort(q2);

        int j = 0, j2 = 0;
        for(int i=0; i<sz2; i++) {
            while(j < sz1 && logs[j][1] < (q2[i]-x)) {
                // System.out.println("Skipped/ removed " + logs[j][0] + ":" + logs[j][1]);
                j++;
                if(fq[logs[j-1][0]] == 0) continue;
                fq[logs[j-1][0]]--;
                if(fq[logs[j-1][0]] == 0) cnt--;
            }
            while(j2 < sz1 && logs[j2][1] < (q2[i]-x)) {
                // System.out.println("not matching " + logs[j2][0] + ":" + logs[j2][1]);
                j2++;
            }
            while(j2 < sz1 && logs[j2][1] >= (q2[i]-x) && logs[j2][1] <= q2[i]) {
                // System.out.println("Considered " + logs[j2][0] + ":" + logs[j2][1]);
                fq[logs[j2][0]]++;
                if(fq[logs[j2][0]] == 1) cnt++;
                j2++;
            }
            mp.put(q2[i], n - cnt);
        }

        for(int i=0; i<sz2; i++) {
            ans[i] = mp.get(q[i]);
        }

        return ans;
    }
}