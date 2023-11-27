class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int ans = 0, sz = gain.size();
        int prev = 0;
        for(int i : gain){
            ans = max(ans, i + prev);
            prev += i;
        }

        return ans;
    }
};