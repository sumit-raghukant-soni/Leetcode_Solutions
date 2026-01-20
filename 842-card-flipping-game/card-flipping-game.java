class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int sz = fronts.length, ans = Integer.MAX_VALUE;
        Set<Integer> st = new HashSet<>();

        for(int i=0; i<sz; i++){
            if(fronts[i] == backs[i]) st.add(fronts[i]);
        }

        for(int i=0; i<sz; i++){
            if(!st.contains(backs[i])){
                ans = ans < backs[i] ? ans : backs[i];
            }
            if(!st.contains(fronts[i])){
                ans = ans < fronts[i] ? ans : fronts[i];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}