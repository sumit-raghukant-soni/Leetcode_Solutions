class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<string> tmp(n+1);
        vector<int> ans(n);

        for(int i=1; i<=n; i++) tmp[i] = to_string(i);

        sort(tmp.begin(), tmp.end());

        for(int i=1; i<=n; i++) ans[i-1] = stoi(tmp[i]);

        return ans;
    }
};