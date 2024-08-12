class Solution {
public:
    void findQuadruplets(vector<int>& nums, set<vector<int>>& ans, int& target, int s, int e, int a, int b){
        
        while(s < e){
            // cout << s << " " << e << endl;
            int c = nums[s], d = nums[e];
            long sum = 1LL * a + b + c + d;
            if(target == sum){
                ans.insert({a, b, c, d});
                s++, e--;
            }
            else if(sum < target) s++;
            else e--;
        }
    }
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        int sz = nums.size();
        if(sz < 4) return {};
        vector<vector<int>> ans;
        set<vector<int>> mp;

        sort(nums.begin(), nums.end());

        for(int i=0; i<sz; i++){
            while(i-1 >= 0 && i < sz && nums[i] == nums[i-1]) i++;
            for(int j=i+1; j<sz; j++){
                while(j-1>=i+1 && j < sz && nums[j] == nums[j-1]) j++;
                if(j < sz) findQuadruplets(nums, mp, target, j+1, sz-1, nums[i], nums[j]);
            }
        }

        for(auto i : mp){
            ans.push_back(i);
        }

        return ans;
    }
};