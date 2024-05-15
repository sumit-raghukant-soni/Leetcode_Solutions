class Solution {
public:
    int sumOfEncryptedInt(vector<int>& nums) {
        int ans = 0, sz = nums.size();
        int cnt, maxi, tmp;

        for(int i=0; i<sz; i++){
            tmp = nums[i], maxi = cnt = 0;
            while(tmp > 0){
                maxi = max(maxi, tmp%10);
                tmp /= 10;
                cnt++;
            }
            for(int j=0; j<cnt; j++){
                ans += maxi * pow(10, j);
            }
        }

        return ans;
    }
};