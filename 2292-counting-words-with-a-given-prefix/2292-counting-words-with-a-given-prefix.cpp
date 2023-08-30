class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int cnt = 0, size = pref.length();

        for(auto i : words)
            if(i.substr(0,size) == pref) cnt++;

        return cnt;
    }
};