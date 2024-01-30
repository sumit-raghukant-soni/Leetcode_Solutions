class Solution {
public:
    string simplifyPath(string path) {
        stack<string> st;
        int sz = path.length();
        string tmp, ans = "";

        for(int i=0; i<sz; i++){
            while(i < sz && path[i] == '/') i++;
            tmp = "";
            while(i < sz && path[i] != '/'){
                tmp += path[i]; i++;
            }
            if(tmp == "..") { if(!st.empty()) st.pop(); }
            else if(tmp != ".") st.push(tmp);
        }
        
        while(!st.empty()){
            if(ans != "") ans = '/' + ans;
            ans = st.top() + ans;
            st.pop();
        }

        return '/' + ans;   
    }
};