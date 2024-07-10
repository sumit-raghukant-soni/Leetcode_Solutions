class Solution {
public:
    int minOperations(vector<string>& logs) {
        int sz = logs.size(), level = 0;

        for(int i=0; i<sz; i++){
            if(logs[i] == "../"){
                if(level > 0) level--;
            } 
            else if(logs[i] != "./") level++;
        }

        return level;
    }
};