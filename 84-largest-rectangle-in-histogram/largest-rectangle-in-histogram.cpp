class Solution {
public:
    vector<int> findPreSmallerElement(vector<int>& heights, int& sz){
        vector<int> arr(sz, 0);
        stack<int> st;
        st.push(-1);

        for(int i=0; i<sz; i++){
            while(st.top() != -1 && heights[st.top()] >= heights[i]){
                st.pop();
            }
            arr[i] = st.top();
            st.push(i);
        }

        return arr;
    }
    vector<int> findNextSmallerElement(vector<int>& heights, int& sz){
        vector<int> arr(sz, 0);
        stack<int> st;
        st.push(-1);

        for(int i=sz-1; i>=0; i--){
            while(st.top() != -1 && heights[st.top()] >= heights[i]){
                st.pop();
            }
            arr[i] = st.top();
            st.push(i);
        }

        return arr;
    }
    int largestRectangleArea(vector<int>& heights) {
        int sz = heights.size(), ans = 0;

        vector<int> pre = findPreSmallerElement(heights, sz), next = findNextSmallerElement(heights, sz);

        for(int i=0; i<sz; i++){
            int l = heights[i];
            if(next[i] == -1) next[i] = sz;
            int b = next[i] - pre[i] - 1;
            // cout << l << " " << next[i] << " " << pre[i] << endl;
            ans = max(ans, l*b);
        }

        return ans;
    }
};