class Solution {
    public int minJumps(int[] arr) {
        int sz = arr.length;
        int costs[] = new int[sz];
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Queue<Pair<Integer, Integer>> pq = new LinkedList<>();

        for (int i = 0; i < sz; i++) {
            mp.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;

        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {

            int sz2 = pq.size();
            for (int i = 0; i < sz2; i++) {
                int curr = pq.peek().getKey(), cost = pq.poll().getValue();
                if (curr == sz - 1) {
                    return cost;
                }
                if (cost > costs[curr])
                    continue;
                if ((curr + 1) < sz && costs[curr + 1] > cost + 1) {
                    pq.add(new Pair(curr + 1, cost + 1));
                    costs[curr + 1] = cost + 1;
                }

                if ((curr - 1) >= 0 && costs[curr - 1] > cost + 1) {
                    pq.add(new Pair(curr - 1, cost + 1));
                    costs[curr - 1] = cost + 1;
                }

                if (mp.containsKey(arr[curr])) {
                    for (int j : mp.get(arr[curr])) {
                        if (costs[j] > cost + 1) {
                            pq.add(new Pair(j, cost + 1));
                            costs[j] = cost + 1;
                        }
                    }
                }
                mp.remove(arr[curr]);
            }
        }

        return costs[sz - 1];
    }
}