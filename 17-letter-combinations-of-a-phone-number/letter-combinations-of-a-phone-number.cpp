class Solution {
public:
    void solve(vector<string>& tmp, int ind, string str, vector<string>& ans){
        if(tmp.size() == ind){
            ans.push_back(str);
            return;
        }
        for(int i=0; i<tmp[ind].length(); i++){
            str += tmp[ind][i];
            solve(tmp, ind+1, str, ans);
            str.pop_back();
        }
    }
    vector<string> letterCombinations(string digits) {
        if(digits.size() == 0) return {};
        vector<string> ans;
        
        unordered_map<char, string> mp = {{'2',"abc"}, {'3',"def"}, {'4',"ghi"}, {'5',"jkl"}, {'6',"mno"}, {'7',"pqrs"}, {'8',"tuv"}, {'9',"wxyz"}}; 
        int sz = digits.size();
        vector<string> tmp;
        for(int i=0; i<sz; i++){
            tmp.push_back(mp[digits[i]]);
        }

        solve(tmp, 0, "", ans);

        return ans;
    }
};