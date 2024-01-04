class Solution {
public:
    int minOperations(vector<int>& nums) {
        unordered_map<int, int> mp;
        int cnt = 0;
        for(auto i : nums) mp[i]++;

        while(!mp.empty()){
            int freq = mp.begin()->second, val = mp.begin()->first;
            mp.erase(mp.begin());
            if(freq > 2){
                cnt += freq/3;
                if(freq%3) cnt++;
            }
            else if(freq == 2) cnt += freq/2;
            else return -1;
        }

        return mp.empty() ? cnt : -1;
    }
};