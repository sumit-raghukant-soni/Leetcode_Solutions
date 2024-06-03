class Solution {
public:
    int appendCharacters(string s, string t) {
        int ssz = s.length(), tsz = t.length();
        int j=0;
        for(int i=0; i<ssz; i++){
            if(j < tsz){
                if(s[i] == t[j]) j++;
            }
            else break;
        }

        return tsz - j;
    }
};