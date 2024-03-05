class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> dep(numCourses, 0), vis(numCourses, 0), ans;
        int sz = prerequisites.size();
        unordered_map<int, vector<int>> adjList;

        for(int i=0; i<sz; i++){
            dep[prerequisites[i][0]]++;
            adjList[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }

        queue<int> q;
        for(int i=0; i<numCourses; i++){
            if(dep[i] == 0) q.push(i);
        }

        while(!q.empty()){
            // cout << "start" << q.size() << endl;
            int front = q.front();
            q.pop();
            ans.push_back(front);
            vis[front]++;
            for(int i : adjList[front]){
                // cout << "for " << front << " " << i << endl;
                if(vis[i] == 0){
                    if(dep[i] > 0) dep[i]--;
                    if(dep[i] == 0) q.push(i);
                }
            }
        }

        return (ans.size() == numCourses) ? ans : vector<int>();
    }
};