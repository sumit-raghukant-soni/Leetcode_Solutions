class Solution {
public:
    string largestGoodInteger(string num) {
        string ans = "";
        int sz = num.length();
        
        for(int i=0; i<sz-2; i++)
            if(num[i] == num[i+1] && num[i] == num[i+2]) ans = max(ans, num.substr(i, 3));
        
        return ans;
    }
};