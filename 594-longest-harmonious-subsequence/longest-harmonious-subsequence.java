class Solution {
    public int findLHS(int[] nums) {
        int sz = nums.length, a = 0, cnt, curr, prev=Integer.MIN_VALUE, ans = 0;
        Arrays.sort(nums);

        for(int i=0; i<sz; i++){
            cnt = 0; curr = nums[i];
            while(i < sz && nums[i] == curr){
                i++;
                cnt++;
            }
            i--;
            if(a == 0){
                a = cnt;
            }
            else if(prev+1 == curr) {
                a += cnt;
                ans = ans > a ? ans : a;
            }
            a = cnt;
            prev = nums[i];
        }

        return ans;
    }
}