class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<int, int> mp;
        int sz = nums.size(), tmp = 0, ans = 0;

        for(int i=0; i<sz; i++)
            mp[nums[i]]++;

        int prev = INT_MIN;
        for(auto i : mp){
            // cout << i.first << " ";
            if(prev == INT_MIN){
                prev = i.first;
                tmp = 1;
            }
            else if(i.first == prev + 1){
                tmp++;
                prev++;
            }
            else{
                ans = max(ans, tmp);
                prev = i.first;
                tmp = 1;
            }
        }
        
        ans = max(ans, tmp);

        return ans;
    }
};