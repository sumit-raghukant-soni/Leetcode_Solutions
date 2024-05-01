class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> mp;
        queue<int> q;
        vector<int> indegree(numCourses, 0), vis(numCourses, 0);
        for(vector<int> i : prerequisites){
            mp[i[0]].push_back(i[1]);
            indegree[i[1]]++;
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.push(i); vis[i]++;
            }
        }

        int courses = 0;
        while(!q.empty()){
            int front = q.front();
            q.pop();
            courses++;
            for(auto i : mp[front]){
                cout << front << ":" << i << " ";
                if(vis[i] == 0){
                    indegree[i]--;
                    if(indegree[i] == 0) {q.push(i); vis[i]++;}
                }
                else return false;
            }
        }

        return courses == numCourses;
    }
};