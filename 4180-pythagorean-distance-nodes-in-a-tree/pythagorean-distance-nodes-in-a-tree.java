class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int arr[][] = null, vis[] = null;

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int sz = edges.length, cnt = 0;
        arr = new int[n][3];
        vis = new int[n];

        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());

        for (int i = 0; i < sz; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        // System.out.println(adjList);

        Arrays.fill(vis, -1);
        addFreq(x, 0);

        Arrays.fill(vis, -1);
        addFreq(y, 1);

        Arrays.fill(vis, -1);
        addFreq(z, 2);

        for (int i = 0; i < n; i++) {
            // System.out.println(i + " " + arr[i][0] + ":" + arr[i][1] + ":" + arr[i][2]);
            if (checkNums(arr[i][0], arr[i][1], arr[i][2])) {
                // return i;
                cnt++;
                // System.out.println("True");
            }
        }

        return cnt;
    }

    private boolean checkNums(int a, int b, int c) {
        return ((a * a) + (b * b) == (c * c)) || ((a * a) + (c * c) == (b * b)) || ((a * a) == (b * b) + (c * c));
    }

    private void addFreq(int root, int ind) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        vis[root] = 1;

        while (!q.isEmpty()) {
            int curr = q.peek().getKey(), c = q.poll().getValue();
            // System.out.println(root + " has " + curr + ":" + c);
            arr[curr][ind] = c++;

            for (int i : adjList.get(curr)) {
                if (vis[i] == -1) {
                    vis[i] = 1;
                    q.add(new Pair(i, c));
                }
            }
        }

    }
}