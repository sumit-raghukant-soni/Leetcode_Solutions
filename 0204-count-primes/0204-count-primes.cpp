class Solution {
public:
    int countPrimes(int n) {
        int cnt = 0;
        vector<bool> prime(n+1, true);
        for(int i=2; i<n; i++){
            if(prime[i]){
                cnt++;
                for(int j=i*2; j<n; j=j+i){
                    prime[j] = false;
                }
            }
        }
        return cnt;
    }
};