class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        vector<string> tmp(numRows);
        int sz = s.length(), j=0, flow=1;
        string ans = "";

        for(int i=0; i<sz; i++){
            if(j == numRows){ j = numRows-2; flow = -1;}
            if(j == -1) { j = 1; flow = 1;}
            tmp[j] += s[i];
            j += flow;
        }   

        for(int i=0; i<numRows; i++) ans += tmp[i];

        return ans;
    }
};