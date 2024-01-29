class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        int sz = intervals.size();
        int start = -1, end = -1;
        sort(intervals.begin(), intervals.end());

        for(int i=0; i<sz; i++){
            if(start == -1){
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else if(intervals[i][0] <= end){
                end = max(end, intervals[i][1]);
            }
            else{
                ans.push_back({start, end});
                start = intervals[i][0], end = intervals[i][1];
            }
        }

        ans.push_back({start, end});

        return ans;
    }
};