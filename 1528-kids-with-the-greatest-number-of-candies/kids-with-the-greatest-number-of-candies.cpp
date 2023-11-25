class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int maxi = *max_element(candies.begin(), candies.end()), sz = candies.size();
        vector<bool> ans(sz, false);

        for(int i=0; i<sz; i++){
            if(candies[i]+extraCandies >= maxi) ans[i] = true;
        }

        return ans;
    }
};