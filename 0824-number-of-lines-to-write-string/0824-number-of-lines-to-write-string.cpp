class Solution {
public:
    vector<int> numberOfLines(vector<int>& widths, string s) {
       int noOfLines = 0, cnt=0;
       for(auto i : s){
           if(cnt + widths[i - 'a'] > 100){
               noOfLines++;
               cnt = widths[i - 'a'];
           }
           else cnt += widths[i - 'a'];
       } 
       return {noOfLines+1, cnt};
    }
};