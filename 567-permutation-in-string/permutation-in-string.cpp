class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int sz1 = s1.length(), sz2 = s2.length();
        int alpha1[26], alpha2[26], flg;

        for(char ch : s1) alpha1[ch-'a']++;

        for(int i=0; i<sz2; i++){
            alpha2[s2[i]-'a']++;
            if(i >= sz1) alpha2[s2[i-sz1] - 'a']--;
            if(i >= sz1-1){
                flg = 0;
                for(int j=0; j<26; j++){
                    if(alpha1[j] == alpha2[j]) flg++;
                }
                if(flg == 26) return true;
            } 
        }

        return false;
    }
};