class Solution {
    public int minMoves2(int[] nums) {
        long s = Integer.MAX_VALUE;
        long e = Integer.MIN_VALUE;

        for (int i : nums) {
            s = Math.min(s, i);
            e = Math.max(e, i);
        }

        while (s < e) {
            long mid = s + (e - s) / 2;

            long a = solve(nums, mid);
            long b = solve(nums, mid + 1);

            if (a <= b) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return (int) solve(nums, s);
    }

    private long solve(int[] nums, long key) {
        long sum = 0;

        for (int num : nums) {
            sum += Math.abs((long) num - key);
        }

        return sum;
    }
}