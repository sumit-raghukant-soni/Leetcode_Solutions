class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        int sz = heights.size(), i=0, diff;
        priority_queue<int> q;

        for(; i<sz-1; i++){
            diff = heights[i+1] - heights[i];
            if(diff <= 0) continue;

            bricks -= diff;
            q.push(diff);

            if(bricks < 0){
                // cout << "pop " << q.top() << endl;
                bricks += q.top();
                q.pop();
                ladders--;
            }

            if(ladders < 0) break;
        }

        return i;
    }
};