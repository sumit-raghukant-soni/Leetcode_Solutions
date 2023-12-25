class StockSpanner {
public:
    vector<int> v;
    int size;
    StockSpanner() {
        size = 0;
    }
    int next(int price) {
        int cnt = 0;
        v.push_back(price);
        size++;
        for(int i=size-1; i>=0; i--){
            if(v[i] > price) break;
            else cnt++;
        }
        return cnt;
    }
};