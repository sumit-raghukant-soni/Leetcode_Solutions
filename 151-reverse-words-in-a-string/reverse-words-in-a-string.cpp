class Solution {
public:
    string reverseWords(string s) {
        string ans = "", tmp = "";
        int sz = s.length(), i=0;

        while(i < sz){
            tmp = "";
            while(i < sz && s[i] != ' '){
                tmp += s[i++];
            }
            if(ans != "" && tmp != "") ans = ' ' + ans;
            ans = tmp + ans;
            i++;
        }

        return ans;
    }
};