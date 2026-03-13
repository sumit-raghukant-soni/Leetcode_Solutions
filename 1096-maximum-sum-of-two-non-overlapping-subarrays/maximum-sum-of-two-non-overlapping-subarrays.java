class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int a = solve(nums, firstLen, secondLen), b = solve(nums, secondLen, firstLen);
        return a > b ? a : b;
    }
    public int solve(int[] nums, int firstLen, int secondLen) {
        // System.out.println("len 1 " + firstLen);
        int sz = nums.length, ans = 0;
        int sum1 = 0, sum2 = 0;

        for(int i=0; i<firstLen-1; i++){
            sum1 += nums[i];
        }

        for(int i=firstLen-1; i<sz; i++){
            if(i >= firstLen) sum1 -= nums[i-firstLen];
            sum1 += nums[i];
            int cnt = 0, tmp = 0;
            sum2 = 0;
            for(int j=i+1; j<sz; j++){
                cnt++;
                tmp += nums[j];
                if(cnt >= secondLen){
                    sum2 = sum2 > tmp ? sum2 : tmp;
                    tmp -= nums[j - (secondLen-1)];
                }
            }
            // System.out.println(i + " = " + sum1 + " " + sum2);
            sum2 = sum2 > tmp ? sum2 : tmp;
            ans = ans > (sum1 + sum2) ? ans : (sum1 + sum2);
        }

        ans = ans > (sum1 + sum2) ? ans : (sum1 + sum2);

        return ans;
    }
}