class Solution {
    public int minAreaRect(int[][] points) {
        int sz = points.length, ans = Integer.MAX_VALUE;
        Set<Pair<Integer, Integer>> st = new HashSet<>();

        for(int i=0; i<sz; i++){
            st.add(new Pair(points[i][0], points[i][1]));
        }

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                Pair<Integer, Integer> a = new Pair(points[i][0], points[j][1]), b = new Pair(points[j][0], points[i][1]);
                if( st.contains(a) && st.contains(b) ){
                    int l = Math.abs(a.getKey() - b.getKey());
                    int w = Math.abs(a.getValue() - b.getValue());
                    if(l != 0 && w != 0){
                        ans = ans < (l*w) ? ans : (l*w);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}