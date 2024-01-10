class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 1) return 0;
        int sz = prices.size(), profit=0;
        
        for(int i=0; i<sz; i++){
            int buy = INT_MAX;
            while(i+1 < sz && prices[i] > prices[i+1]) i++;
            buy = i<sz ? prices[i] : INT_MAX;
            // cout << i << " ";
            while(i+1 < sz && prices[i] < prices[i+1]) i++;
            if(i<sz) profit += prices[i] - buy;
            // cout << i << endl;
        }

        return profit;
    }
};