class Solution {
public:
    vector<int> result, childCount;
    int root_result, N;

    void dfsChild(unordered_map<int, vector<int>>& adjList, int par_node, int pre_node){

        for(int& child : adjList[par_node]){
            if(child == pre_node) continue;

            result[child] = result[par_node] - childCount[child] + (N - childCount[child]);

            dfsChild(adjList, child, par_node);
        }
    }

    int dfsRoot(unordered_map<int, vector<int>>& adjList, int curr_node, int par_node, int curr_depth){
        int total_count = 1;

        root_result += curr_depth;

        for(int& child : adjList[curr_node]){
            if(child == par_node) continue;
            total_count += dfsRoot(adjList, child, curr_node, curr_depth+1);
        }

        childCount[curr_node] = total_count;
        
        return total_count;
    }
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adjList;
        vector<int> visited(n, 0), sum(n, 0);
        childCount.resize(n, 0);
        result.resize(n, 0);

        int sz = edges.size();
        N = n;

        for(int i=0; i<sz; i++){
            adjList[edges[i][0]].push_back(edges[i][1]);
            adjList[edges[i][1]].push_back(edges[i][0]);
        }

        root_result = 0;

        dfsRoot(adjList, 0, -1, 0);

        result[0] = root_result;

        dfsChild(adjList, 0, -1);

        return result;
    }
};