class Solution {
public:
    string largestGoodInteger(string num) {
        int sz = num.length();
        string ans = "";
        
        for(int i=0; i<sz-2; i++){
            if(num[i] == num[i+1] && num[i+1] == num[i+2]){
                string tmp(3, num[i]);
                ans = ans > tmp ? ans : tmp;
            }
        }

        return ans;
    }
};