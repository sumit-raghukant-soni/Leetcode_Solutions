class Solution {
    Map<Integer, Integer> mp = new HashMap<>();
    public int sumFourDivisors(int[] nums) {
        int sz = nums.length, ans = 0;

        for(int i=0; i<sz; i++){
            int tmp = 0;
            if(mp.containsKey(nums[i])) tmp = mp.get(nums[i]);
            else{
                tmp = calc(nums[i]);
                mp.put(nums[i], tmp);
            }
            if(tmp > 0) ans += 1 + nums[i] + tmp;
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