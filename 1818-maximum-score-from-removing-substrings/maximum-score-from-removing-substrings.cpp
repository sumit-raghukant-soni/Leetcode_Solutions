class Solution {
public:
    int maximumGain(string s, int x, int y) {
        int sz = s.length(), ans = 0;
        vector<char> st, st2;

        int mx = max(x, y), mn = min(x, y);
        string maxi = x > y ? "ab" : "ba", mini = y > x ? "ab" : "ba";

        for(int i=0; i<sz; i++){
            if(!st.empty() && st.back() == maxi[0] && s[i] == maxi[1]){
                st.pop_back();
                ans += mx;
            }
            else st.push_back(s[i]);
        }

        for(int i=0; i<st.size(); i++){
            if(!st2.empty() && st2.back() == mini[0] && st[i] == mini[1]){
                st2.pop_back();
                ans += mn;
            }
            else st2.push_back(st[i]);
        }
        
        return ans;
    }
};