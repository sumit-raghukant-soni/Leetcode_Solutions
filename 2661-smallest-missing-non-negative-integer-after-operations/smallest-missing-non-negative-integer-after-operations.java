class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int sz = nums.length, maxi = nums[0], ans = 0;
        int freq[] = new int[value];

        for(int i=0; i<sz; i++){
            freq[((nums[i] % value) + value) % value]++;
        }

        while(freq[ans % value]-- > 0){
            ans++;
        }

        return ans;
    }
}