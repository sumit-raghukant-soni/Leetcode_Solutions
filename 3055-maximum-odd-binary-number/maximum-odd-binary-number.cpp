class Solution {
public:
    string maximumOddBinaryNumber(string s) {
        int cnt = 0, sz = s.length();
        string ans = s;
        
        for(int i=0; i<sz; i++)
            if(ans[i] == '1') cnt++;

        for(int i=0; i<sz; i++){
            if(cnt > 1){
                ans[i] = '1';
                cnt--;
            }
            else if(i == sz-1 && cnt == 1) ans[i] = '1';
            else ans[i] = '0';
        }

        return ans;
    }
};