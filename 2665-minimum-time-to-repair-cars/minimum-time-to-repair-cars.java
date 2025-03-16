class Solution {
    public long repairCars(int[] ranks, int cars) {
        long ans = Long.MAX_VALUE, s = 0, e = Long.MAX_VALUE;

        while(s <= e){
            long mid = s + (e-s)/2;
            // System.out.println(s + " " + mid + " " + e);
            if(check(ranks, cars, mid)){
                ans = Math.min(ans, mid);
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }

        return ans;
    }

    private boolean check(int[] ranks, int cars, long maxi){
        // System.out.println("For " + maxi);
        int sz = ranks.length, k = 0, i = 0;
        long curr;

        while(k < cars && i < sz){
            curr = 0;
            long val = 0;
            while((curr*curr)*ranks[i] <= maxi && curr <= cars){
                val = curr;
                curr++;
            }
            // System.out.println("with " + maxi + " = " + i + " <> " + curr);
            k += (int) val;
            i++;
        }

        return k >= cars;
    }
}