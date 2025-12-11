class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int sz = buildings.length, row=0;
        int tr[] = new int[n+1], tc[] = new int[n+1];
        int rSum = 0, cSum[] = new int[n+1], cnt = 0;

        Arrays.sort(buildings, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int i=0; i<sz; i++){
            int r = buildings[i][0], c = buildings[i][1];
            tr[r]++; tc[c]++;
        }
        for(int i=0; i<sz; i++){
            int r = buildings[i][0], c = buildings[i][1];
            if(r > row){
                row = r;
                rSum = 0;
            }
            if(rSum > 0 && rSum+1 < tr[r] && cSum[c] > 0 && cSum[c]+1 < tc[c]){
                cnt++;
            }
            rSum++;
            cSum[c]++;
        }

        return cnt;
    }
}