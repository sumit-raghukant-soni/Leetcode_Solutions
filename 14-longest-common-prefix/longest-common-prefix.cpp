class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string tmp = strs[0];
        int sz = strs.size(), ind = tmp.length();
        for(int i=1; i<sz; i++){
            int j = 0, sz2 = strs[i].size();
            while(j < sz2 && j < ind && tmp[j] == strs[i][j]){
                j++;
            }
            ind = min(ind, j);
        }
        return tmp.substr(0, ind);
    }
};