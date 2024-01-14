class Solution {
public:
    bool closeStrings(string word1, string word2) {
        int sz = word1.length();
        if(word2.length() != sz) return false;
        vector<int> alpha1(26, 0), alpha2(26, 0);
        
        for(int i=0; i<sz; i++){
            alpha1[word1[i] - 'a']++;
            alpha2[word2[i] - 'a']++;
        }

        for(int i=0; i<26; i++){
            if((alpha1[i] == 0 && alpha2[i] != 0) || (alpha2[i] == 0 && alpha1[i] != 0)) return false;
        }

        sort(alpha1.begin(), alpha1.end());
        sort(alpha2.begin(), alpha2.end());
        
        return alpha1 == alpha2;
    }
};