class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        HashMap<Pair<Integer, Integer>, Integer> mp = new HashMap<>();
        HashMap<Integer, Integer> p_b = new HashMap<>();
        HashSet<Integer> winners = new HashSet<>();

        int winning_players = 0;
        for (int i = 0; i < pick.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(pick[i][0], pick[i][1]);
            if (p_b.containsKey(pick[i][0]) == false || p_b.get(pick[i][0]) == pick[i][1]) {
                if (mp.containsKey(pair)) {
                    mp.put(pair, mp.get(pair) + 1);
                } else
                    mp.put(pair, 1);
            }
        }

        for (int i = 0; i < pick.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(pick[i][0], pick[i][1]);
            if (mp.get(pair) >= pick[i][0] + 1)
                winners.add(pick[i][0]);
            // System.out.println(pick[i][0] + ":" + pick[i][1] + " = " + mp.get(pair));
        }

        return winners.size();
    }
}