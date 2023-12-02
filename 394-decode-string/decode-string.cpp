class Solution {
public:
    string decodeString(string s) {
        string ans = "", num = "";
        stack<pair<int, string>> st;
        int sz = s.length();
        for(int i=0; i<sz; i++){
            if(s[i] >= '0' && s[i] <= '9') num += s[i];
            else if(s[i] == '[') {
                st.push({stoi(num), ans});
                num = ans = "";
            }
            else if(s[i] == ']') {
                int k = st.top().first;
                string prev = st.top().second;
                st.pop();
                for(int j=0; j<k; j++) prev += ans;
                ans = prev;
            }
            else ans += s[i];
        }

        return ans;
    }
};