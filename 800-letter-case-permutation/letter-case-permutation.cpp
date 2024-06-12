class Solution {
public:
    void getPermutations(string s, vector<string>& ans, int ind, int sz){
        if(ind == sz){
            ans.push_back(s);
            return;
        }

        if(!(s[ind] >= '0' && s[ind] <= '9')){
            string tmp = s;
            tmp[ind] ^= 32;
            getPermutations(tmp, ans, ind+1, sz);    
        }
        getPermutations(s, ans, ind+1, sz);

    }
    vector<string> letterCasePermutation(string s) {
        vector<string> ans;

        getPermutations(s, ans, 0, s.length());

        return ans;
    }
};