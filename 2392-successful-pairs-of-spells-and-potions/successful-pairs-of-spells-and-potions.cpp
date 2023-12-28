class Solution {
public:
    int solve(vector<int>& potions, long long success, int addon, int s, int e){
        if(s > e) return 0;
        if(s == e){
            if(1LL * potions[s] * addon < success) return potions.size();
            return s;
        }

        int mid = s + (e-s)/2;
        if(1LL * potions[mid] * addon >= success){
            e = mid;
        }
        else{
            s = mid+1;
        }
        return solve(potions, success, addon, s, e);
    }
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        vector<int> ans;
        sort(potions.begin(), potions.end());
        int sz = spells.size(), sz2 = potions.size();
        for(int i=0; i<sz; i++){
            int cnt = solve(potions, success, spells[i], 0, sz2-1);
            if(cnt == sz2) cnt = 0;
            else cnt = sz2 - cnt;
            ans.push_back(cnt);
        }

        return ans;
    }
};