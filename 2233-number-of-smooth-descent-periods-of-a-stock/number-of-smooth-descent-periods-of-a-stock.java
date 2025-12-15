class Solution {
    public long getDescentPeriods(int[] prices) {
        int sz = prices.length, cnt = 0;
        long ans = 0;

        for(int i=0; i<sz; i++){
            if(i-1 >= 0){
                if(prices[i-1]-1 == prices[i]) cnt++;
                else{
                    ans += cnt == 1 ? cnt : (1L*cnt*(cnt+1))/2;
                    cnt = 1;
                }
            }
            else cnt++;
            // System.out.println(ans);
        }

        if(cnt > 1) ans += (1L * cnt * (cnt+1))/2;
        else ans++;

        return ans;
    }
}