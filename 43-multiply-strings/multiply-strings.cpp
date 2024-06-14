class Solution {
public:
    string mul(string base, char ch){
        int sz = base.length(), a, b = int(ch - '0'), carry = 0;
        string ans = "";

        // cout << " for " << a << ", " << b << endl;

        for(int i=sz-1; i>=0; i--){
            a = int(base[i] - '0');
            carry = carry + (a*b);
            ans = char((carry%10) + '0') + ans;
            carry /= 10;
            // cout << ans << " ";
        }
        // cout << endl;

        if(carry != 0)
            ans = char(carry + '0') + ans;

        return ans;
    }
    string add(string a, string b){
        if(a == "") return b;
        int sz1 = a.length(), sz2 = b.length();
        int carry = 0, v1, v2 , i=sz1-1, j=sz2-1;

        if(sz1 > sz2) return add(b, a);

        string ans = "";

        while(i >= 0){
            v1 = a[i]-'0', v2 = b[j]-'0';
            carry += v1 + v2;
            ans = char(carry%10 + '0') + ans;
            carry /= 10;
            i--, j--;
        }

        while(j >= 0){
            int val = b[j] - '0';
            carry += val;
            ans = char(carry%10 + '0') + ans;
            carry /= 10;
            j--;
        }

        if(carry != 0){
            ans = char(carry + '0') + ans;
            carry /= 10;
        }
        return ans;
    }
    string multiply(string num1, string num2) {
        if(num1 == "0" || num2 == "0") return "0";
        string ans = "", tmp;
        int sz2 = num2.length();
        unordered_map<char, string> mp;

        for(int i=sz2-1; i>=0; i--){
            if(mp.find(num2[i]) == mp.end()){
                tmp = mul(num1, num2[i]);
                mp[num2[i]] = tmp;
            }
            else tmp = mp[num2[i]];

            for(int j=0; j<sz2-1-i; j++) tmp += '0';
            ans = add(tmp, ans);
        }

        return ans;
    }
};