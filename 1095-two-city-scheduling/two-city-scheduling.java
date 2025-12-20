class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int sz = costs.length, ans = 0;

        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        for(int i=0; i<sz; i++){
            if(i < sz/2) ans += costs[i][0];
            else ans += costs[i][1];
        }

        return ans;
    }
}