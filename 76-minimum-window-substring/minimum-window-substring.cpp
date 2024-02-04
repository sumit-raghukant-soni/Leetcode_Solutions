class Solution {
public:
    string minWindow(string s, string t) {
        int sz = s.length(), sz2 = t.length(), st = 0, e = 0, cnt = 0, minLength = INT_MAX;
        string ans = "";
        unordered_map<char, int> org, mp;
        if(sz < sz2 || sz == 0 || sz2 == 0) return "";

        for(int i=0; i<sz2; i++){
            org[t[i]]++;
        }
        
        for(int i=0; i<sz; i++){
            e = i;
            if(org.find(s[i]) != org.end()){
                mp[s[i]]++;
                if(mp[s[i]] <= org[s[i]]) cnt++;
            }

            if(cnt >= sz2){
                while(org.find(s[st]) == org.end() || mp[s[st]] > org[s[st]]){
                    mp[s[st]]--;
                    st++;
                }
                if(e - st + 1 < minLength){
                    minLength = e - st + 1;
                    ans = s.substr(st, minLength);
                }
            }
        }

        return ans;
    }
};