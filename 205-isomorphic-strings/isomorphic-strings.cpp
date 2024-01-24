class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int sz = s.length();
        unordered_map<int, int> a, b;

        for(int i=0; i<sz; i++){
            if(a.find(s[i] - 'a') != a.end() || b.find(t[i] - 'a') != b.end()){
                if(a[s[i] - 'a'] != t[i] - 'a') return false;
                if(b[t[i] - 'a'] != s[i] - 'a') return false;   
            }
            else{
                a[s[i] - 'a'] = t[i] - 'a';
                b[t[i] - 'a'] = s[i] - 'a';
            }
        }

        return true;
    }
};