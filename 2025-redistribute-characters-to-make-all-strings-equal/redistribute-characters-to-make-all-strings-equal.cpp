class Solution {
public:
    int alpha[26];
    bool makeEqual(vector<string>& words) {
        ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
        int sz = words.size();

        for(auto i : words)
            for(char j : i) alpha[j - 'a']++;

        for(int i=0; i<26; i++) if(alpha[i]%sz != 0) return false;

        return true;
    }
};