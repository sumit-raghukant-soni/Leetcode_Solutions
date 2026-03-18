class Solution {
    public long minNumberOfSeconds(int mh, int[] wt) {
        int sz = wt.length;
        long s = 0, e = Long.MAX_VALUE, ans = 0;

        while (s <= e) {
            long mid = s + (e - s) / 2;
            boolean isValid = check(mh, wt, mid);
            if (isValid) {
                ans = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }

        return ans;
    }

    public boolean check(int mh, int[] wt, long mid) {
        int sz = wt.length;
        long sum = 0;

        for (int i = 0; i < sz; i++) {
            sum += (long)(Math.sqrt(1 + (8.0 * mid) / wt[i]) - 1) / 2;
        }

        return sum >= mh;
    }
}