class Solution {
public:
    int lengthOfLastWord(string s) {
        int cnt = 0, i=s.length()-1;
        while(i >= 0 && s[i] == ' ') i--;
        while(i >=0 && s[i] != ' '){ i--; cnt++;}
        return cnt;
    }
};