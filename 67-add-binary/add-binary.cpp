class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.length()-1, j = b.length()-1;
        bool carry = false;
        bool v1 = false, v2 = false;
        string ans = "";
        while(i >= 0 || j >= 0){
            v1 = i>=0 ? (a[i] == '1') : false;
            v2 = j>=0 ? (b[j] == '1') : false;
            i--, j--;
            if(v1 && v2 && carry){
                ans = '1' + ans;
                carry = true;
            }
            else if(v1 && v2){
                ans = '0' + ans;
                carry = true;
            }
            else if((v1 && carry) || (v2 && carry)){
                carry = true;
                ans = '0' + ans;
            }
            else if(v1 || v2 || carry){
                ans = '1' + ans;
                carry = false;
            }
            else ans = '0' + ans;
        }
        if(carry) ans = '1' + ans;
        return ans;
    }
};