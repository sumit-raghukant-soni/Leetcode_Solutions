class Solution {
public:
    int getLucky(string s, int k) {
        int ans = 0;
        int sz = s.length();
        for(int i=0; i<sz; i++){
            int tmp = s[i] - 'a' + 1;
            if(tmp < 10) ans += tmp;
            else ans += (tmp/10) + (tmp%10);
        }

        while(k > 1){
            int tmp = ans;
            ans = 0;
            while(tmp > 0){
                ans += tmp%10;
                tmp /= 10;
            }
            k--;
        }

        return ans;
    }
};