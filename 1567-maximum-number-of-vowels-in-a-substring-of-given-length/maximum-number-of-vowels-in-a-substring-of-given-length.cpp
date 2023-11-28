class Solution {
public:
    int maxVowels(string s, int k) {
        int ans = 0, cnt = 0;
        int sz = s.length();

        for(int i=0; i<sz; i++){
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') cnt++;
            if(i >= k-1){
                ans = max(cnt, ans);
                if(s[i-(k-1)] == 'a' || s[i-(k-1)] == 'e' || s[i-(k-1)] == 'i' || s[i-(k-1)] == 'o' || s[i-(k-1)] == 'u') cnt--;
            }
        }

        return ans;
    }
};