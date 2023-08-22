class Solution {
public:
    string convertToTitle(int columnNumber) {
        string ans="";
        while(columnNumber > 0){
            int val = columnNumber%(26);
            if(val == 0){
                ans = 'Z' + ans;
                columnNumber -= 26;
            }
            else{
                ans = char(val-1 + 'A') + ans;
                columnNumber -= columnNumber%(26);
            }
            columnNumber /= 26;
        }
        return ans;
    }
};