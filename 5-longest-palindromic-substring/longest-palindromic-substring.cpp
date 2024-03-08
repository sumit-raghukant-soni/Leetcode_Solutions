class Solution {
public:
    string longestPalindrome(string s) {
        int sz = s.length(), cnt = 0;
        string ans = "";
        string str, rts;
        for(int i=0; i<sz; i++){
            str = rts = "";
            for(int j=i; j<sz; j++){
                str += s[j];
                if(s[i] == s[j] && (j-i+1) > cnt){
                    rts = str;
                    reverse(rts.begin(), rts.end());
                    if(rts == str){
                        cnt = j-i+1;
                        ans = str;
                    }
                }
            }
        }

        return ans;
    }
};