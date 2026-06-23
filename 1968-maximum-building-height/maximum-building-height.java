class Solution {
    public int maxBuilding(int n, int[][] r) {
        int sz = r.length, ans = 0, dis, curr;
        
        if(sz == 0) {
            return n-1;
        }

        Arrays.sort(r, (a, b) -> a[0] - b[0]);
        

        r[0][1] = Math.min(r[0][1], (r[0][0] - 1));
        for(int i=1; i<sz; i++){
            dis = r[i][0] - r[i-1][0];
            r[i][1] = Math.min(r[i][1], r[i-1][1] + dis);
        }

        for(int i=sz-2; i>=0; i--){
            dis = r[i+1][0] - r[i][0];
            r[i][1] = Math.min(r[i][1], r[i+1][1] + dis);
        }


        dis = r[0][0] - 1;
        curr = (r[0][1] + dis)/2;
        ans = Math.max(ans, curr);

        for(int i=1; i<sz; i++){
            dis = r[i][0] - r[i-1][0];
            curr = (r[i][1] + r[i-1][1] + dis)/ 2;
            ans = Math.max(ans, curr);
        }

        ans = Math.max(ans, r[sz-1][1] + (n - r[sz-1][0]));

        return ans;
    }
}