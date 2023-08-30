class Solution {
public:
    int bestClosingTime(string customers) {
        int y=0, n=0, size = customers.size();
        // vector<int> dp(size+1, 0);
        for(auto i : customers) if(i == 'N') n++;
        int p=0, val=INT_MAX, ind=0;
        for(int i=size-1; i>=0; i--){
            if(customers[i] == 'Y'){
                // dp[i+1] = y++ + n;
                p = y++ + n;
            }
            else{
                // dp[i+1] = y + n--;
                p = y + --n;
            }
            if(p <= val){
                val = p;
                ind = i;
            }
        }
        // dp[0] = y;
        if(y+n <= val) return 0;
        return ind+1;
    }
};