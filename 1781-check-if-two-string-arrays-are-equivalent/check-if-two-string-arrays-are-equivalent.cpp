class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        string tmp = "";
        for(auto i : word1) tmp += i;

        int sz = word2.size(), prev = 0;
        for(int i=0; i<sz; i++){
            int k = word2[i].length();
            if(tmp.substr(prev, k) != word2[i]) return false;
            prev += k;
        }

        return tmp.length() == prev;
    }
};