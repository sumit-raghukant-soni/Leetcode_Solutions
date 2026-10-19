class Solution {
    public int minSwaps(int[] nums) {
        int sz = nums.length, cnt = 0;
        int tmp[][] = new int[sz][2];
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();

        for(int i=0; i<sz; i++) {
            if(!mp.containsKey(nums[i])) {
                mp.put(nums[i], calc(nums[i]));
            }
            tmp[i][0] = nums[i];
            mp2.put(nums[i], i);
        }

        Arrays.sort(tmp, (a, b) -> {
            if(mp.get(a[0]) != mp.get(b[0])) return mp.get(a[0]) - mp.get(b[0]);
            return a[0] - b[0];
        });

        for(int i=0; i<sz; i++) {
            if(tmp[i][0] != nums[i]) {
                int ind = mp2.get(tmp[i][0]);
                swap(nums, i, ind);
                mp2.put(nums[i], i);
                mp2.put(nums[ind], ind);
                cnt++;
            }
        }

        return cnt;
    }

    private int calc(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }

    private void swap(int nums[], int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
        return;
    }
}