class Solution {
    public long interchangeableRectangles(int[][] rect) {
        int sz = rect.length;
        long ans = 0;
        double tmp = 0;
        Map<Double, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            tmp = (1.0 * rect[i][0])/rect[i][1];
            mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
        }

        for(Map.Entry<Double, Integer> e : mp.entrySet()){
            ans += calc(e.getValue());
        }

        // System.out.println(mp);

        return ans;
    }

    private long calc(int i){
        long ans = 0;

        while(i-- > 0){
            ans += i;
        }

        return ans;
    }
}