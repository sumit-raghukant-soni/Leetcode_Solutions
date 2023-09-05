class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        int cnt=0;
        for(int i=0; i<nums.size(); i++){
            int j = i, gcd = nums[i];
            int tcnt = 0;
            while(j<nums.size()){
                gcd = (1LL*gcd*nums[j]) / (__gcd(gcd, nums[j]));
                if(nums[j] <= k){
                    if(gcd == k) tcnt++;
                }
                else break;
                j++;
            }
            // cout << cnt << " " << tcnt << " " << nums[i] << endl;
            cnt += tcnt;
        }
        return cnt;
    }
};