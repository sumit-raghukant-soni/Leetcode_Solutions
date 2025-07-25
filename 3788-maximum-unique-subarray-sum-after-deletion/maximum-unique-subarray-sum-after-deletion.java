class Solution {
    public int maxSum(int[] nums) {
        int sz = nums.length, ans = 0;
        int freq[] = new int[201];

        for(int i=0; i<sz; i++){
            freq[nums[i] + 100]++;
        }

        for(int i=101; i<201; i++){
            if(freq[i] > 0) ans += i-100;
        }

        if(ans == 0){
            for(int i=100; i>=0; i--) if(freq[i] > 0) return i - 100;
        }

        return ans;
    }
}