class Solution {
public:
    bool cmp(int a[], int b[]){
        for(int i=0; i<26; i++)
            if(a[i] != b[i]) return false;
        return true;
    }
    vector<int> findAnagrams(string s, string p) {
        int alpha[26] = {0}, tmp[26] = {0};
        vector<int> ans;
        for(auto i : p) alpha[i - 'a']++;

        for(int i=0; i<s.length(); i++){
            tmp[s[i] - 'a']++;
            if(i >= p.length()-1){
                if(cmp(tmp, alpha)) ans.push_back(i - p.length()+1);
                tmp[s[i - p.length() + 1] - 'a']--;
            }
        }
        return ans;
    }
};