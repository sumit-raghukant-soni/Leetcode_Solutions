class Solution {
    public int longestNiceSubarray(int[] nums) {
        int sz = nums.length, ans = 1, cnt = 0, j = 0;
        long sum = 0;

        for(int i=0; i<sz; i++){
            if((sum&nums[i]) == 0){
                sum = sum | nums[i];
            }
            else{
                while(j <= i && (sum & nums[i]) != 0){
                    sum = (sum ^ nums[j++]);
                    cnt--;
                }
                sum = sum | nums[i];
            }
            cnt++;
            ans = Math.max(ans, cnt);
            // System.out.println(nums[i] + " " + Integer.toBinaryString((int) nums[i]));
            // System.out.println(Integer.toBinaryString((int) sum) + " " + sum + " " + cnt);
        }

        return ans;
    }
}