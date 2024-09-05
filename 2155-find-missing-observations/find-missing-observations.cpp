class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        int sz = rolls.size();
        long sum = 0;
        for(int i=0; i<sz; i++){
            sum += rolls[i];
        }

        long long total = mean * (sz+n);

        total -= sum;

        if(total < n || total > n*6) return {};
        vector<int> ans(n, 1);
        total -= n;
        for(int i=0; i<n; i++){
            if(total >= 5){
                total -= 5;
                ans[i] += 5;
            }
            else{
                ans[i] += total;
                total = 0;
            }
        }

        return ans;
    }
};