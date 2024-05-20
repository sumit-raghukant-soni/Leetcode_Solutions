class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        int groupNo[26] = {0};
        int sz = s1.length(), no = 0;
        string ans = "";

        for(int i=0; i<sz; i++){
            int no1 = groupNo[s1[i] - 'a'], no2 = groupNo[s2[i] - 'a'];
            if(no1 != 0 && no2 != 0){
                int newNo = min(no1, no2);
                for(int k=0; k<26; k++) if(groupNo[k] == no1 || groupNo[k] == no2) groupNo[k] = newNo;
            }
            else if(no1 != 0) groupNo[s2[i] - 'a'] = no1;
            else if(no2 != 0) groupNo[s1[i] - 'a'] = no2;
            else groupNo[s1[i] - 'a'] = groupNo[s2[i] - 'a'] = ++no;
        }
        
        unordered_map<char, int> mp;
        for(int i=0; i<26; i++){
            // cout << char(i+'a') << ":" << groupNo[i] << " ";
            mp[char(i+'a')] = groupNo[i];
        }

        for(int i=0; i<baseStr.length(); i++){
            int no = groupNo[int(baseStr[i] - 'a')];
            if(no == 0) ans += baseStr[i];
            else{
                for(int j=0; j<26; j++){
                    if(groupNo[j] == no){
                        ans += char(j + 'a');
                        break;
                    }
                }
            }
        }

        return ans;
    }
};