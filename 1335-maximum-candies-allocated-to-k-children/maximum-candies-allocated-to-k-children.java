class Solution {
    public int maximumCandies(int[] candies, long k) {
        long s = 1, e = Integer.MAX_VALUE;
        int ans = 0;

        Arrays.sort(candies);

        while(s <= e){
            long mid = s + (e-s)/2;
            boolean chk = check(candies, k, mid);
            // System.out.println(s + "< " + mid +  " >" + e + " " + chk);

            if(chk){
                ans = (int) mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        
        return (int) ans;
    }

    private boolean check(int[] arr, long total, long x){
        int i = arr.length-1;
        long tmp = 0, k = 0;

        while(k < total){
            if(i < 0 && tmp < x) break;
            if(i >= 0 && tmp < x) tmp = arr[i--];
            if(tmp >= x){
                k += tmp/x;
                // System.out.println(tmp + " " + k);
                tmp = 0;
            }
        }

        // System.out.println(k + " " + total);
        return k >= total;
    }
}