class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i = 0, j=0, cnt = 0, ans = 0;
        int sz = nums.size(), tmp = k;

        for(int i=0; i<sz; i++){
            if(tmp == 0 && nums[i] == 0){
                ans = max(cnt, ans);
                while(j <= i && nums[j] != 0){
                    j++; cnt--;
                }
                j++;
            }
            else if(tmp > 0 && nums[i] == 0){
                tmp--;
                cnt++;
            }
            else cnt++;
        }

        if(tmp >= 0) ans = max(ans, cnt);

        return ans;
    }
};