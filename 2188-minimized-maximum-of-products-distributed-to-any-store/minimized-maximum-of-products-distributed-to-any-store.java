class Solution {
    public int solve(int[] qs, int cap){
        int cnt = 0, sz = qs.length;

        for(int i=0; i<sz; i++){
            cnt += qs[i]/cap + ((qs[i]%cap) == 0 ? 0 : 1);
        }

        return cnt;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int ans = Integer.MAX_VALUE, s = 1, e = Integer.MAX_VALUE;

        while(s <= e){
            int mid = s + (e-s)/2;
            int n2 = solve(quantities, mid);

            if(n2 == n) ans = Math.min(ans, mid);
            if(n2 > n){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }

        return s;
    }
}