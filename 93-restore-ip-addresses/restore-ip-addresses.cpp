class Solution {
public:
    void solve(string s, int& sz, vector<vector<int>>& ans, int col, int ind, vector<int> arr){
        // cout << ind << endl;
        // for(int i : arr) cout << i << " ";
        // cout << endl;
        if(col == 0 && ind == sz){
            bool valid = true;
            for(int i=0; i<4; i++){
                valid = valid && (arr[i] <= 255) && (arr[i] >= 0);
            }
            if(valid) ans.push_back(arr);
        }
        if(ind > sz || col <= 0) return;
        
        int tmp = 0;
        for(int i=ind; i < min(sz, ind+3); i++){
            tmp += s[i] - '0';
            arr.push_back(tmp);
            solve(s, sz, ans, col-1, i+1, arr);
            arr.pop_back();
            tmp *= 10;
            if(tmp == 0) break;
        }
    }
    vector<string> restoreIpAddresses(string s) {
        int sz = s.length();
        vector<vector<int>> ans;
        vector<string> fans;

        solve(s, sz, ans, 4, 0, {});

        // for(auto i : ans){
        //     for(int j : i) cout << j << " ";
        //     cout << endl;
        // }

        for(auto i : ans){
            string tmp = "";
            for(int j : i){
                tmp += to_string(j);
                tmp += ".";
            }
            tmp.pop_back();
            fans.push_back(tmp);
        }

        return fans;
    }
};