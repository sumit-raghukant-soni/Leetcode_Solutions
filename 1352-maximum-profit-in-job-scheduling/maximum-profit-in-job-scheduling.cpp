class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int sz = profit.size();
        vector<tuple<int, int, int>> jobs;

        for(int i=0; i<sz; i++) jobs.push_back({endTime[i], startTime[i], profit[i]});

        sort(jobs.begin(), jobs.end());
        vector<int> dp(sz+1);

        for(int i=0; i<sz; i++){
            auto [end, start, profit] = jobs[i];

            int maxPreviousProfit = upper_bound(jobs.begin(), jobs.begin()+i, start, [&](int time, const auto& job){
                return time < get<0>(job);
            }) - jobs.begin();
            dp[i+1] = max(dp[i], dp[maxPreviousProfit] + profit);
        }

        return dp[sz];
    }
};