class Solution {
public:
    string capitalizeTitle(string title) {
        string ans = "";
        int sz = title.length();
        string tmp = "";
        for(int i=0; i<sz; i++){
            if(title[i] == ' '){
                if(tmp.length() > 2)
                    tmp[0] = tmp[0] ^ 32;
                if(ans != "") ans += " ";
                ans += tmp;
                tmp = "";
            }
            else if(title[i] >= 'A' && title[i] <= 'Z') tmp += title[i] ^ 32;
            else tmp += title[i];
        }

        if(tmp.length() > 2){
            tmp[0] = tmp[0] ^ 32;
        }
        if(ans != "") ans += " ";
        ans += tmp;
        tmp = "";

        return ans;
    }
};