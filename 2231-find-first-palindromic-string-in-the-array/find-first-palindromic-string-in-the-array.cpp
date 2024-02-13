class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        int sz = words.size();
        string tmp;

        for(int i=0; i<sz; i++){
            tmp = words[i];
            reverse(tmp.begin(), tmp.end());
            if(words[i] == tmp) return words[i];
        }

        return "";
    }
};