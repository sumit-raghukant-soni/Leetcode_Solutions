class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        long long ans = 0;
        vector<int> tmp = happiness;
        sort(tmp.begin(), tmp.end(), greater<int>());

        for(int i=0; i<k; i++)
            if(tmp[i]-i >= 0) ans += tmp[i] - i;

        return ans;
    }
};