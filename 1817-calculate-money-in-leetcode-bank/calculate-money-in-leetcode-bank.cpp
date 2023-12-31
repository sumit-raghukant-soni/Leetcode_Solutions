class Solution {
public:
    int totalMoney(int n) {
        int mp[7] = {0,1,3,6,10,15,21};
        int ans = 0, tmp = 0, itr= n/7;
        
        for(int i=0; i<itr; i++){
            ans += 28 + tmp;
            tmp += 7;
        }

        ans += mp[(n%7)] + ((n%7) * tmp/7);

        return ans;
    }
};