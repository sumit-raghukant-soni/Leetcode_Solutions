class Solution {
public:
    int calculate(string s) {
        int sz = s.length();
        stack<int> st;
        stack<char> ops;

        int tmp;

        for (int i = 0; i < sz; i++) {
            if (s[i] == ' ') continue;

            tmp = 0;
            if(s[i] >= '0' && s[i] <= '9'){
                while(i < sz && s[i] >= '0' && s[i] <= '9'){
                    tmp = (tmp*10) + (s[i++] - '0');
                }
                i--;

                if(!ops.empty() && (ops.top() == '*' || ops.top() == '/')){
                    int tmp2 = st.top();
                    st.pop();
                    if(ops.top() == '*') tmp = (tmp * tmp2);
                    else tmp = (tmp2 / tmp);

                    if(!ops.empty() && ops.top() == '-'){
                        tmp = -tmp;
                        ops.pop();
                    }
                    else if(!ops.empty() && ops.top() == '+'){
                        ops.pop();
                    }
                    
                    st.push(tmp);
                    ops.pop();

                    // cout << tmp << endl;
                }
                else if(!ops.empty() && ops.top() == '-'){
                    st.push(-tmp);
                    ops.pop();
                    // cout << -tmp << endl;
                }
                else{
                    // cout << tmp << endl;
                    st.push(tmp);
                }
            }
            else{
                // cout << s[i] << endl;
                ops.push(s[i]);
            }
        }

        tmp = 0;
        while(!st.empty()){
            // cout << st.top() << endl;
            tmp += st.top();
            st.pop();
        }

        return tmp;
    }
};