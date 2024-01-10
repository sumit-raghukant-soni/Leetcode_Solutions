class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit=0, sz = prices.size();
        int buy=prices[0], sell = prices[0];
        for(int i=1; i<sz; i++){
            if(prices[i] < buy){
                buy = prices[i];
                sell = prices[i];
            }
            else if(sell < prices[i]) sell = prices[i];
            profit = max(profit, sell - buy);
        }
        return profit;
    }
};