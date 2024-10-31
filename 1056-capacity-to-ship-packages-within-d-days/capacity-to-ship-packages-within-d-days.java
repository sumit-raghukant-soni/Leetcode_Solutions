class Solution {
    public int solve(int[] weights, int sz, int limit, int days, int i){
        if(i == sz) return days;

        int j=i, sum = 0;
        while(j < sz && sum+weights[j] <= limit){
            sum += weights[j];
            j++;
        }
        if(j == i) return 1000000000;
        // System.out.println(days + " " + sum);
        return solve(weights, sz, limit, days+1, j);
    }
    public int shipWithinDays(int[] weights, int days) {
        int sz = weights.length, maxi = 0;

        for(int i=0; i<sz; i++){
            maxi += weights[i];
        }

        int s = 1, e = maxi+1, ans = maxi;
        while(s <= e){
            int mid = s + (e-s)/2;
            int days2 = solve(weights, sz, mid, 0, 0);
            // System.out.println(s + " = " + e + " " + mid + " " + days2);
            if(days2 <= days){
                ans = Math.min(ans, mid);
            }
            
            if(days2 > days){
                s = mid+1;
            }
            else e = mid-1;
        }


        return ans;
    }
}