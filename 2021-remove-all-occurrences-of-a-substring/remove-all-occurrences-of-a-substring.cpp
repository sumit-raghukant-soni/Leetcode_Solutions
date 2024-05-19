class Solution {
public:
    string removeOccurrences(string s, string part) {
        string ans = "";
        int sz = s.length(), psz = part.length(), asz = 0;
        for(int i=0; i<sz; i++){
            if(asz >= psz){
                int ind = asz-psz;
                if(ans.substr(ind, psz) == part){
                    ans.erase(ind, psz);
                    asz -= psz;
                }
            }
            if(asz+1 == psz){
                ans += s[i];
                asz++;
                int ind = asz-psz;
                if(ans.substr(ind, psz) == part){
                    ans.erase(ind, psz);
                    asz -= psz;
                    continue;
                }
                else{
                    ans.pop_back();
                    asz--;
                }
            }
            if(i+psz <= sz && s.substr(i, psz) == part) i+= psz-1;
            else{
                ans += s[i];
                asz++;
            }
            // cout << ans << endl;
        }

        if(ans.length() >= psz){
            int ind = asz-psz;
            if(ans.substr(ind, psz) == part){
                ans.erase(ind, psz);
                asz -= psz;
            }
        }

        return ans;
    }
};