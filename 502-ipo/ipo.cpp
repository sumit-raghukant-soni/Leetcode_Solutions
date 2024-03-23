class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {

        vector<pair<int, int>> v;
        int N = profits.size();
        for(int i = 0; i < N; i++) {
            v.push_back({profits[i], capital[i]});
        }
        sort(v.begin(), v.end(), [&](pair<int, int> &p1, pair<int, int> &p2){
            return p2.second > p1.second;
        });
        
        priority_queue<int> pq;
        int i = 0;
        k = min(k, N);

        while(k--)
        {
            while (v[i].second <= w && i < N) {
                pq.push(v[i].first);
                i++;
            }
            
            if(!pq.empty()) {
                w += pq.top();
                pq.pop();
            }
        }
        return w;
    }
};