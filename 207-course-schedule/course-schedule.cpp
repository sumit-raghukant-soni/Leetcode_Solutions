class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        queue<int> q;
        unordered_map<int, vector<int>> mp;
        vector<int> indegree(numCourses, 0);
        int sz = prerequisites.size();
        if(sz == 0) return true;

        for(int i=0; i<sz; i++){
            mp[prerequisites[i][0]].push_back(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0) q.push(i);
        }

        vector<int> topo;

        while(!q.empty()){
            int front = q.front();
            q.pop();
            // cout << front << " ";
            topo.push_back(front);
            for(auto i : mp[front]){
                indegree[i]--;
                if(indegree[i] == 0) q.push(i);
            }
        }

        return topo.size() == numCourses;
    }
};