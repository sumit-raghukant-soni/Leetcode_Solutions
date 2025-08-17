class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size(), ans = m;
        long sum = 0;
        Map<Long, Integer> cnt = new HashMap<>();

        for(int i=0; i<m; i++){
            sum = 0;
            for(int j=0; j<wall.get(i).size(); j++){
                sum += wall.get(i).get(j);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }

        // System.out.println(cnt);

        for(Map.Entry<Long, Integer> e : cnt.entrySet()){
            long i = e.getValue(), j = e.getKey();
            if(j > 0 && j < sum) ans = (int) Math.min(ans, m - i);
        }

        return ans;    
    }
}