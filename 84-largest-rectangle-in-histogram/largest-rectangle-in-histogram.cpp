class Solution {
public:
    vector<int> nextSmaller(vector<int>& vec, int sz){
        stack<int> st;
        st.push(-1);

        vector<int> ans(sz, -1);

        for(int i=sz-1; i>=0; i--){
            while(st.top() != -1 && vec[st.top()] >= vec[i]) st.pop();
            
            ans[i] = st.top();
            
            st.push(i);
        }

        return ans;
    }
    vector<int> previousSmaller(vector<int> vec, int sz){
        stack<int> st;
        st.push(-1);

        vector<int> ans(sz, -1);

        for(int i=0; i<sz; i++){
            while(st.top() != -1 && vec[st.top()] >= vec[i]) st.pop();

            ans[i] = st.top();

            st.push(i);
        }

        return ans;
    }

    int largestArea(vector<int>& mat, vector<int>& pre, vector<int>& next, int sz){
        int ans = 0;

        for(int i=0; i<sz; i++){
            int l = mat[i];
            if(next[i] == -1) next[i] = sz;
            int b = next[i] - pre[i] - 1;
            
            int newArea = l*b;
            ans = max(ans,  newArea);
        }

        return ans;
    }
    int largestRectangleArea(vector<int>& heights) {
        int sz = heights.size();
        vector<int> pre = previousSmaller(heights, sz), next = nextSmaller(heights, sz);
        return largestArea(heights, pre, next, sz);
    }
};