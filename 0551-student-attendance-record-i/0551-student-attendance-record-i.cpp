class Solution {
public:
    bool checkRecord(string s) {
        int absentCnt = 0, maxConLate = 0;
        for(int i=0; i<s.length(); i++){
            if(s[i] == 'A') absentCnt++;
            else if(s[i] == 'L'){
                int tmp = 0;
                while(i < s.length() && s[i] == 'L'){
                    i++;
                    tmp++;
                }
                if(i < s.length() && s[i] != 'L') i--;
                maxConLate = max(tmp, maxConLate);
            }
        }
        return absentCnt < 2 && maxConLate <= 2;
    }
};