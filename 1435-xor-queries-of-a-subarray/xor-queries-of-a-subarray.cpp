class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int sz = arr.size();
        vector<int> pre(sz, 0), ans;
        pre[0] = arr[0];
        for(int i=1; i<sz; i++){
            pre[i] = pre[i-1] ^ arr[i];
        }

        for(vector<int> i : queries){
            if(i[0] == 0) ans.push_back(pre[i[1]]);
            else ans.push_back(pre[i[0]-1] ^ pre[i[1]]);
        }

        return ans;
    }
};