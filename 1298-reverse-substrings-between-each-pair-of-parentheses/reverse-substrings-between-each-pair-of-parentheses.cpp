class Solution {
public:
    string solve(string s, int& sz, int& i){
        if(i >= sz) return "";

        string tmp = "";
        bool rev = true;
        if(s[i] == '(') i++;
        else rev = false;

        for(; i<sz; i++){
            if(s[i] == '('){
                tmp += solve(s, sz, i);
                // cout << tmp << " " << i << endl;
            }
            else if(s[i] == ')') break;
            else tmp += s[i];
        }

        if(!rev) return tmp;
        int st = 0, e = tmp.length()-1;
        while(st < e){
            swap(tmp[st++], tmp[e--]);
        }
        // cout << tmp << endl;
        return tmp;
    }
    string reverseParentheses(string s) {
        int sz = s.length(), i=0;
        
        string ans = "";

        for(; i<sz; i++){
            if(s[i] == '(') ans += solve(s, sz, i);
            else ans += s[i];
        }

        return ans;
    }
};