class Solution {
public:
    int countbits(int n){
        int cnt=0;
        while(n){
            int rem = n & 1;
            if(rem)
                cnt++;
            n = n >> 1;
        }
        return cnt;
    }
    vector<int> countBits(int n) {
        vector<int> ans;

        for(int i=0; i<=n; i++){
            ans.push_back(countbits(i));
        }

        return ans;
    }
};