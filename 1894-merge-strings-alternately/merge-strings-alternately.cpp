class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string ans = "";

        int sz1 = word1.length(), sz2 = word2.length();
        int sz = max(sz1, sz2);
        for(int i=0; i<sz; i++){
            if(i < sz1){
                ans += word1[i];
            }
            if(i < sz2){
                ans += word2[i];
            }
        }

        return ans;
    }
};