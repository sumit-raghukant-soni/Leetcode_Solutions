class Solution {
public:
    int solve(string s, int& i, int& sz){
        // cout << endl << "ind " << s[i] << endl;
        int ans = 0, sign = 1, val = 0;
        for(; i<sz && s[i] != ')'; i++){
            // cout << s[i] << ":" << val << "=" << ans << " " << sign << endl;
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
                int tmp = solve(s, i, sz);
                // cout << "value gained " << tmp << endl;
                val = tmp;
            } 
            // cout << ans << " ";
        }
        // cout << "end value " << val * sign << " ";
        ans += val * sign;
        // i++;
        return ans;
    }
    int calculate(string s) {
        string corrected = "";
        int sz = s.length(), ind = 1;

        for(int i=0; i<sz; i++){
            if(s[i] != ' ') corrected += s[i];
        }
        
        corrected = '(' + corrected + ')';
        // cout << corrected << endl;
        sz++;
        return solve(corrected, ind, sz);
    }
};