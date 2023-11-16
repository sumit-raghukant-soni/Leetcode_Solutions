class Solution {
public:
    bool checkZeroOnes(string s) {
        int i = 0, sz = s.length();
        int cnt, o=0, z=0;
        while(i < sz){
            char tmp = s[i];
            cnt = 0;
            while(i < sz && s[i] == tmp){
                cnt++;
                i++;
            }
            if(tmp == '1') o = max(o, cnt);
            else z = max(z, cnt);
        }

        return o > z;
    }
};