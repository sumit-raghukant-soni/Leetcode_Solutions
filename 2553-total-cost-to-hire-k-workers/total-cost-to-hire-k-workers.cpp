class Solution {
public:
    long long totalCost(vector<int>& costs, int k, int candidates) {
        int sz = costs.size();
        int si=0, sj=candidates-1, ei = sz - candidates, ej=sz-1; 
        long long int ans = 0;
        multiset<pair<int, int>> st1, st2;
        unordered_map<int, int> vis;

        for(int i=0; i<candidates && i < sz; i++) st1.insert({costs[i], i});
        for(int i=0; i<candidates && i < sz; i++) st2.insert({costs[sz-1-i], sz-1-i});

        for(int i=0; i<k; i++){
            // if(sz == 25) cout << i << endl;
            int ind1 = st1.size() ? st1.begin()->second : INT_MAX;
            int ind2 = st2.size() ? st2.begin()->second : INT_MAX;
            
            while(vis.find(ind1) != vis.end()){
                st1.erase(st1.begin());
                if(st1.size() == 0) break;
                ind1 = st1.begin()->second;
            }
            while(vis.find(ind2) != vis.end()){
                st2.erase(st2.begin());
                if(st2.size() == 0) break;
                ind2 = st2.begin()->second;
            }
            
            int min1 = st1.size() ? st1.begin()->first : INT_MAX;
            int min2 = st2.size() ? st2.begin()->first : INT_MAX;

            // if(sz == 5) cout << min1 << " " << min2 << endl;
            if(min1 <= min2){
                ans += min1;
                st1.erase(st1.begin());
                vis[ind1]++;
                if(sj < sz-1){
                    sj++;
                    st1.insert({costs[sj], sj});
                }
            }
            else{
                ans += min2;
                st2.erase(st2.begin());
                vis[ind2]++;
                if(ei > 0) {
                    ei--;
                    st2.insert({costs[ei], ei});
                }
            }
        }
        
        return ans;
    }
};