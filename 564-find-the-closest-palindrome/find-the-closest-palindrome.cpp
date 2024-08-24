class Solution {
public:
    long long make(int val, int sz){
        long long ans = val, tmp = val;
        if(val == 0 || allNine(val)){
            ans = 0;
            for(int i=1; i<sz; i++) ans = ans * 10 + 9;
            return ans;
        }
        if(sz%2 == 1) val /= 10;

        while(val){
            ans = ans*10 + val%10;
            val /= 10;
        }

        return ans;
    }
    bool allNine(int n){
        while(n){
            if(n%10 != 9) return false;
            n /= 10;
        }
        return true;
    }
    int size(int n){
        int cnt = 0;
        while(n){
            cnt++;
            n /= 10;
        }
        return cnt;
    }
    string nearestPalindromic(string n) {
        int sz = n.length();
        int half = 0;
        long long org = 0;

        for(int i=0; i<sz; i++){
            org = org*10 + n[i] - '0';
        }
        if(org < 10) return to_string(org-1);
        if(allNine(org)) return to_string(org+2);

        for(int i=0; i<(sz+1)/2; i++){
            half = half * 10 + int(n[i] - '0');
        }

        long long a = half + 1, b = half - 1, c = half;

        a = make(a, (a%10 == 0) ? sz+1 : sz);
        b = make(b, sz);
        c = make(c, sz);
        if(c == org) c = INT_MAX;

        cout << org << " " << half << " " << a << " " << b << " " << c << endl;

        if(abs(a - org) < abs(b - org) && abs(a - org) < abs(c - org)){
            return to_string(a);
        }
        else if(abs(b - org) <= abs(a - org) && abs(b - org) <= abs(c - org)){
            return to_string(b);
        }

        return to_string(c);
    }
};