class Solution {
public:
    vector<string> solve(vector<string> vec1, vector<string> vec2){
        int sz1 = vec1.size(), sz2 = vec2.size();
        vector<string> ans;
        for(int i=0; i<sz1; i++){
            for(int j=0; j<sz2; j++){
                ans.push_back(vec1[i] + vec2[j]);
            }
        }
        return ans;
    }
    vector<string> letterCombinations(string digits) {
        int sz = digits.size();
        vector<string> tmp;
        unordered_map<char, vector<string>> mp = {{'2',{"a","b","c"}}, {'3',{"d","e","f"}}, {'4',{"g","h","i"}}, {'5',{"j","k","l"}}, {'6',{"m","n","o"}}, {'7',{"p","q","r","s"}}, {'8',{"t","u","v"}}, {'9',{"w","x","y","z"}} }; 

        for(int i=0; i<sz; i++){
            if(i == 0) tmp = mp[digits[i]];
            else {
                tmp = solve(tmp, mp[digits[i]]);
            }
        }

        return tmp;
    }
};