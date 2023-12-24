class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int sz = temperatures.size();
        vector<int> ans(sz, 0);
        stack<pair<int, int>> st;

        for(int i=sz-1; i>=0; i--){
            if(!st.empty()){
                while(!st.empty() && st.top().first <= temperatures[i]) st.pop();
                if(!st.empty()) ans[i] = st.top().second - i;
            }
            st.push({temperatures[i], i});
        }

        return ans;
    }
};