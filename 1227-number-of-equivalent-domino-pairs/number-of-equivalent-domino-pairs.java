class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int sz = dominoes.length, ans = 0;
        Map<Pair<Integer, Integer>, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            int a = dominoes[i][0] > dominoes[i][1] ? dominoes[i][1] : dominoes[i][0];
            int b = dominoes[i][0] < dominoes[i][1] ? dominoes[i][1] : dominoes[i][0];
            Pair<Integer, Integer> p = new Pair(a,b);
            mp.put(p, mp.getOrDefault(p, 0) + 1);
        }

        // System.out.println(mp);
        for(Map.Entry<Pair<Integer, Integer>, Integer> e : mp.entrySet()){
            if(e.getValue() > 1){
                ans += (e.getValue() * (e.getValue()-1))/2;
            }
        }

        return ans;
    }
}