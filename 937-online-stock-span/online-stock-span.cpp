class StockSpanner {
public:
    vector<int> ans;
    StockSpanner() {
    }
    
    int next(int price) {
        ans.push_back(price);
        int val = 0, sz = ans.size();
        for(int i=sz-1; i>=0 && ans[i] <= price; i--){ val++; }
        return val;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */