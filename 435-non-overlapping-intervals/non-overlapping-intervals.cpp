class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        int ans = 0, sz = intervals.size();

        sort(intervals.begin(), intervals.end(), [&](auto const& a, auto const& b){
            return a[1] < b[1];
        });

        int prev = intervals[0][1];
        for(int i=1; i<sz; i++){
            if(intervals[i][0] < prev) ans++;
            else prev = intervals[i][1];
        }

        return ans;
    }
};