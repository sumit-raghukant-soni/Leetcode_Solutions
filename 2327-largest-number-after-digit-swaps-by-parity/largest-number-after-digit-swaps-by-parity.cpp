class Solution {
public:
    int largestInteger(int num) {
        vector<int> tmp;
        multiset<int, greater<int>> odd, even;
        int n = num;
        while(n > 0){
            tmp.insert(tmp.begin(), n%10);
            if((n%10)%2 == 0){
                even.insert(n%10);
            }
            else odd.insert(n%10);
            n /= 10;
        }

        int ans = 0;
        for(int i=0; i<tmp.size(); i++){
            if((tmp[i]&1) == 0){
                ans = ans*10 + *(even.begin());
                even.erase(even.begin());
            }
            else{
                ans = ans*10 + *(odd.begin());
                odd.erase(odd.begin());
            }
        }

        return ans;
    }
};