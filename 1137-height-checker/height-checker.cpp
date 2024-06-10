class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> tmp = heights;
        sort(tmp.begin(), tmp.end());
        int sz = heights.size(), ans = 0;

        for(int i=0; i<sz; i++)
            if(heights[i] != tmp[i]) ans++;

        return ans;
    }
};