class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        map<int, vector<int>> in, out;
        int sz = connections.size(), cnt = 0;
        unordered_map<int, int>vis;
        queue<int> q;
        q.push(0);
        for(int i=0; i<sz; i++){
            int c = connections[i][0], n = connections[i][1];
            in[n].push_back(c);
            out[c].push_back(n);
        }

        while(!q.empty()){
            int front = q.front();
            cout << front << endl;
            vis[front]++;
            q.pop();
            for(auto i : out[front]){
                if(!vis[i]){
                    cnt++;
                    q.push(i);
                }
            }
            for(int i : in[front]){
                if(!vis[i]) q.push(i);
            }
        }

        return cnt;
    }
};