class Solution {
    public int[] assignTasks(int[] s, int[] t) {
        int n = s.length, m = t.length;
        int[] ans = new int[m];

        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            available.add(new int[]{s[i], i});
        }

        long time = 0;

        for (int i = 0; i < m; i++) {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] curr = busy.poll();
                available.add(new int[]{(int) curr[1], (int) curr[2]});
            }

            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] curr = busy.poll();
                    available.add(new int[]{(int) curr[1], (int) curr[2]});
                }
            }

            int[] server = available.poll();

            ans[i] = server[1];

            busy.add(new long[]{ time + t[i], server[0], server[1] });
        }

        return ans;
    }
}