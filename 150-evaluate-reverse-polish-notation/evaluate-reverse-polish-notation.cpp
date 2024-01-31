using func = function<int(int, int)>;
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int sz = tokens.size();
        stack<int> st;
        unordered_map<string, func> mp = {
            {"+", [] (int a, int b) {return a + b; } },
            {"-", [] (int a, int b) {return a - b; } },
            {"*", [] (int a, int b) {return a * b; } },
            {"/", [] (int a, int b) {return a / b; } }
        };

        for(int i=0; i<sz; i++){
            cout << i << " ";
            if(mp.find(tokens[i]) != mp.end()){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.pop();
                st.push(mp[tokens[i]](b, a));
            }
            else st.push(stoi(tokens[i]));
        }

        return st.top();
    }
};