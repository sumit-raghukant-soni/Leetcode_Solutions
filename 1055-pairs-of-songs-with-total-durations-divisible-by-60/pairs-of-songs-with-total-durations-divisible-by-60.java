class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int sz = time.length, cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<sz; i++){
            // System.out.print(time[i] + " ");
            time[i] %= 60;
            int another = (60 - time[i])%60;
            // System.out.println(another);
            cnt += mp.getOrDefault(another, 0);
            mp.put(time[i], mp.getOrDefault(time[i], 0) + 1);
        }

        return cnt;
    }
}