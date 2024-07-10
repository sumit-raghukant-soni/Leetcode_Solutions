class Solution {
public:
    int minOperations(vector<string>& logs) {
        stack<string> st;
        int sz = logs.size();
        string tmp = "";

        for(int i=0; i<sz; i++){
            if(logs[i] == "../"){
                if(!st.empty()) st.pop();
            } 
            else if(logs[i] != "./") st.push(tmp);
        }

        return st.size();
    }
};