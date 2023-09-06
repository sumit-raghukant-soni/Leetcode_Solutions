class Solution {
public:
    int minOperations(vector<string>& logs) {
        stack<string> st;
        int sz = logs.size();
        
        for(int i=0; i<sz; i++){
            if(logs[i] == "../"){
                if(st.size()) st.pop();
            }
            else if(logs[i] != "./"){
                st.push(logs[i]);
            }
        }

        return st.size();
    }
};