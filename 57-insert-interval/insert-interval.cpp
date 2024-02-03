class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        if(intervals.size() == 0) return {newInterval};
        // if(intervals[0][0] > newInterval[1]){
        //     intervals.insert(intervals.begin(), newInterval);
        //     return intervals;
        // }
        if(intervals.back()[1] < newInterval[0]){
            intervals.push_back(newInterval);
            return intervals;
        }
        vector<vector<int>> ans;
        int sz = intervals.size();
        int i=0;
        
        while(i < sz && intervals[i][1] < newInterval[0]){
            ans.push_back(intervals[i++]);
        }

        int start1 = intervals[i][0], end1 = intervals[i][1];
        
        int prev = i;
        while(i < sz && intervals[i][0] <= newInterval[1]) {prev = i; i++;}
        
        int start2 = intervals[prev][0], end2 = intervals[prev][1];

        if(start2 > newInterval[1]) 
            ans.push_back(newInterval);
        else
            ans.push_back({min(start1, newInterval[0]), max(intervals[prev][1], newInterval[1])}); 

        while(i < sz){
            ans.push_back(intervals[i++]);
        }

        return ans;
    }
};