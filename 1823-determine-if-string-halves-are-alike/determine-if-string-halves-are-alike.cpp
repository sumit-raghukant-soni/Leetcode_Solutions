class Solution {
public:
    bool halvesAreAlike(string s) {
        int sz = s.length();
        int cnt1 = 0, cnt2 = 0;

        for(int i=0; i<sz; i++){
            char tmp = tolower(s[i]);
            if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u'){
                if(i < sz/2){
                    cnt1++;
                }
                else cnt2++;
            }
        }

        return cnt1 == cnt2;
    }
};