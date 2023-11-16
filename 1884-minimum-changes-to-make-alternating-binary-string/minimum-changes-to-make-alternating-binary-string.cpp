class Solution {
public:
    int minOperations(string s) {
        int d1 = 0, d2 = 0, sz = s.length();

        for(int i=0; i<sz; i++){
            if((i&1) == 0){
                if(s[i] != '0') d1++;
                else d2++;
            }
            else{
                if(s[i] != '0') d2++;
                else d1++;
            }
        }

        return min(d1, d2);
    }
};