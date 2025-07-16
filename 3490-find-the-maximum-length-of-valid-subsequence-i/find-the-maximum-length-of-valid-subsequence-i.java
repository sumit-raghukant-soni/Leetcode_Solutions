class Solution {
    public int maximumLength(int[] nums) {
        int sz = nums.length, e = 0, o = 0, cnt =0, ans = 0;
        boolean flg = false;

        for(int i=0; i<sz; i++){
            if(nums[i]%2 == 0){
                e++;
                if(!flg){
                    flg = !flg;
                    cnt++;
                }
            }
            else {
                o++;
                if(flg){
                    flg = !flg;
                    cnt++;
                }
            }
        }

        ans = cnt;

        cnt = 0;
        flg = true;
        for(int i=0; i<sz; i++){
            if(nums[i]%2 == 0){
                if(!flg){
                    flg = !flg;
                    cnt++;
                }
            }
            else if(flg){
                flg = !flg;
                cnt++;
            }
        }

        ans = Math.max(ans, cnt);
        ans = Math.max(ans, e);
        ans = Math.max(ans, o);
        return ans;
    }
}