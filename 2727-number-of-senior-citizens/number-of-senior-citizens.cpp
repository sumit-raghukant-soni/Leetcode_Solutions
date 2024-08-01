class Solution {
public:
    int countSeniors(vector<string>& details) {
        int ans = 0;

        for(string i : details) if((i[11]-'0')*10 + (i[12]-'0') > 60) ans++;

        return ans;
    }
};