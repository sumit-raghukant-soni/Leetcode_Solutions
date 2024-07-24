class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        int sz = nums.size(), val, tmp, unit;
        unordered_map<int, int> mp, imp;

        for(int i=0; i<sz; i++){
            val = 0, tmp = nums[i], unit = 1;
            imp[nums[i]] = i;
            if(mp.find(tmp) == mp.end()){
                val += unit * mapping[tmp%10];
                tmp /= 10;
                unit += 10;
                while(tmp){
                    // cout << val << ",";
                    val += unit * mapping[tmp%10];
                    tmp /= 10;
                    unit *= 10;
                }
                // cout << endl;
                // cout << nums[i] << " " << val << endl;
                mp[nums[i]] = val;
            }
        }

        // for(auto i : mp){
        //     cout << i.first << ":" << i.second << endl;
        // }

        sort(nums.begin(), nums.end(), [&](int& a, int& b){
            return (mp[a] == mp[b]) ? imp[a] < imp[b] : mp[a] < mp[b];
        });

        return nums;
    }
};