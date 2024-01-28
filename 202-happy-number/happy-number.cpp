class Solution {
public:
    bool isHappy(int n) {
        unordered_map<int, int> mp;
        mp[n]++;
        while(n > 1){
            int tmp = 0;
            while(n){
                int rem = n%10;
                tmp += rem*rem;
                n/=10;
            }
            n = tmp;
            if(mp.find(n) != mp.end()) return false;
            mp[n]++;
        }
        return true;
    }
};