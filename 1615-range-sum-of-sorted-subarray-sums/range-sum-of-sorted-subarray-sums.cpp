class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        int sz = nums.size(), k=0;
        vector<long long> tmp((sz*(sz+1))/2, 0);
        long long val = 0, MOD = 1e9 + 7;

        for(int i=0; i<sz; i++){
            val = 0;
            for(int j=i; j<sz; j++){
                val = (val + nums[j])%MOD;
                tmp[k++] = val;
            }
        }
        
        sort(tmp.begin(), tmp.end());
        val = 0;
        for(int i=left-1; i<right; i++){
            val = (val + tmp[i])%MOD;
        }

        return val;
    }
};