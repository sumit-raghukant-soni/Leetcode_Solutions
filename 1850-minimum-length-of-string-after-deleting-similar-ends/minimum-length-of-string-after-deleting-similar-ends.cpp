class Solution {
public:
    int minimumLength(string str) {
        int sz = str.length(), cnt = 0;
        int s=0, e=sz-1;

        while(s < e){
            if(str[s] != str[e]) break;
            char ch = str[s];
            // cout << s << " " << e << endl;
            while(s <= e && str[s] == ch) s++;
            while(e >= s && str[e] == ch) e--;
        }

        // cout << s << " " << e << endl;
        return e-s+1;
    }
};