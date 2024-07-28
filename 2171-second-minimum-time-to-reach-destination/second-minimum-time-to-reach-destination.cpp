class Solution {
public:
    int secondMinimum(int n, vector<vector<int>>& edges, int time, int change) {
        unordered_map<int, vector<int>> adj;

        for(auto i : edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }   

        vector<int> dis1(n+1, INT_MAX), dis2(n+1, INT_MAX), freq(n+1, 0);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        q.push({0, 1});

        while(!q.empty()){
            int timeTaken = q.top().first, topNode = q.top().second;
            q.pop();
            freq[topNode]++;
            if(freq[topNode] == 2 && topNode == n) return timeTaken;

            if((timeTaken/change)&1){
                timeTaken = change * ((timeTaken/change) + 1) + time;
            }
            else timeTaken += time;

            for(int i : adj[topNode]){
                if(freq[i] == 2) continue;
                if(dis1[i] > timeTaken){
                    dis2[i] = dis1[i];
                    dis1[i] = timeTaken;
                    q.push({timeTaken, i});
                }
                else if(dis2[i] > timeTaken && dis1[i] != timeTaken){
                    dis2[i] = timeTaken;
                    q.push({timeTaken, i});
                }
            }
        }

        return 0;
    }
};