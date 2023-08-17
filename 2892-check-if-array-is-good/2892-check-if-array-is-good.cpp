class Solution {
public:
    int cnt[201] = {0};
    bool isGood(vector<int>& nums) {
        int maxi = 0;
        for(auto i : nums){
            cnt[i]++;
            maxi = maxi > i ? maxi : i;
        }

        for(int i=1; i<100; i++){
            if(i == maxi && cnt[i] == 2) return true;
            if(cnt[i] != 1) break;
        }
        return false;
    }
};