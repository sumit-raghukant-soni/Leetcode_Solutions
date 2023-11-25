class Solution {
public:
    bool check(string& tmp, string& str1, string& str2){
        int sz1 = tmp.length(), sz2 = str1.length(), sz3 = str2.length();
        if(sz2%sz1 != 0 || sz3%sz1 != 0) return false;

        int i=0;
        while(i <sz2){
            if(str1.substr(i, sz1) != tmp) return false;
            i += sz1;
        }
        i=0;
        while(i <sz3){
            if(str2.substr(i, sz1) != tmp) return false;
            i += sz1;
        }
        return true;
    }
    string gcdOfStrings(string str1, string str2) {
        int sz1 = str1.length(), sz2 = str2.length();

        string tmp = "", ans = "";
        int j=0, gcd = __gcd(sz1, sz2);
        while(j<gcd){
            if(str1[j] == str2[j]) {
                tmp += str1[j++];
                bool c = check(tmp, str1, str2);
                if(c) ans = tmp;
            }
            else break;
        }

        return ans;
    }
};