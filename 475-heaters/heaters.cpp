class Solution {
public:
    int findRadius(vector<int>& hs, vector<int>& h) {
        int sz = h.size(), hsz = hs.size(), j=0;
        sort(hs.begin(), hs.end());
        sort(h.begin(), h.end());
        vector<int> nh, dis(hsz, INT_MAX);

        while(j < sz && hs[0] > h[j]){
            nh.push_back(h[j++]);
        }

        for(int i=0; i<hsz; i++){
            while(j < sz && hs[i] >= h[j]) nh.push_back(h[j++]);
            if(!nh.empty()) dis[i] = abs(hs[i] - nh.back());
        }

        nh.clear();
        j=sz-1;
        while(j >= 0 && hs[hsz-1] < h[j]){
            nh.push_back(h[j--]);
        }
        for(int i=hsz-1; i>=0; i--){
            while(j >= 0 && hs[i] <= h[j]) nh.push_back(h[j--]);
            if(!nh.empty()) dis[i] = min(dis[i], abs(hs[i] - nh.back()));
        }

        int ans = 0;
        for(int i=0; i<hsz; i++){
            cout << dis[i] << " ";
            ans = max(ans, dis[i]);
        }

        return ans;
    }
};