class Solution {
    public int sumFourDivisors(int[] nums) {
        int sz = nums.length, ans = 0;

        for(int i=0; i<sz; i++){
            int tmp = calc(nums[i]);
            ans += tmp > 0 ? 1 + nums[i] + tmp : 0;
        }

        return ans;
    }

    private int calc(int n){
        int sum = 0, cnt = 0;

        for(int i=2; i<=n/2; i++){
            if(cnt > 3) break;
            if(n%i == 0){
                cnt++;
                sum += i;
            }
        }

        return cnt == 2 ? sum : 0;
    }
}