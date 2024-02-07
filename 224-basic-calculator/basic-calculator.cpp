class Solution {
public:
    int solve(string s, int& i, int& sz){
        int ans = 0, sign = 1, val = 0;
        for(; i<sz && s[i] != ')'; i++){
            if(s[i] >= '0' && s[i] <= '9') val = (val*10) + int(s[i] - '0');
            else if(s[i] == '-'){
                ans += val * sign;
                sign = -1;
                val = 0;
            }
            else if(s[i] == '+'){
                ans += val * sign;
                sign = 1;
                val = 0;
            }
            else if(s[i] == '('){
                i++;
                val = solve(s, i, sz);
            } 
        }
        ans += val * sign;
        return ans;
    }
    int calculate(string s) {
        string corrected = "";
        int sz = s.length(), ind = 1;

        for(int i=0; i<sz; i++)
            if(s[i] != ' ') corrected += s[i];
        
        corrected = '(' + corrected + ')';
        sz++;
        return solve(corrected, ind, sz);
    }
};