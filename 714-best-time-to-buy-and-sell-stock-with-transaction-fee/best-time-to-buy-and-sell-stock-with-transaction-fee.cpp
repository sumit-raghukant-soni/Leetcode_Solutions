class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        int n0 = 0, n1 = 0;
        for(int idx = n - 1; idx >= 0; idx--) {
            n1 = max(-prices[idx] + n0, n1);
            n0 = max(prices[idx] - fee + n1, n0); 
        }
        return n1;
    }
};