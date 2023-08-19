class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string> mp;
        bool at;
        for(int i=0; i<emails.size(); i++){
            string tmp = "";
            at = false;
            for(int j=0; j<emails[i].length()-4; j++){
                if(emails[i][j] == '+' && !at){
                    while(j < emails[i].length() && emails[i][j] != '@')
                        j++;
                    if(j != emails[i].length()) j--;
                }
                else if(at && emails[i][j] == '.')
                    tmp += emails[i][j];
                else if(emails[i][j] != '.')
                    tmp += emails[i][j];
                if(emails[i][j] == '@') at = true;
            }
            mp.insert(tmp);
        }

        return mp.size();
    }
};