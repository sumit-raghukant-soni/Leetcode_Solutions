class Solution {
public:
    int maxDepth(string s) {
        int sz = s.length(), ans = 0, cnt = 0;

        for(int i=0; i<sz; i++){
            if(s[i] == '(') cnt++;
            else if(s[i] == ')') cnt--;
            ans = max(ans, cnt);
        }

        return ans;
    }
};