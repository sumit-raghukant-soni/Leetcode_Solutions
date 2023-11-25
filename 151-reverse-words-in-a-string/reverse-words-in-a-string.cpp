class Solution {
public:
    string reverseWords(string s) {
        int sz = s.length();
        string ans = "", tmp;

        for(int i=0; i<sz; i++){
            tmp = "";
            while(i<sz && s[i] == ' ') i++;
            while(i<sz && s[i] != ' ') tmp += s[i++];
            if(tmp != ""){
                if(ans == "")
                    ans = tmp;
                else
                    ans = tmp + " " + ans;
            }
        }

        return ans;
    }
};