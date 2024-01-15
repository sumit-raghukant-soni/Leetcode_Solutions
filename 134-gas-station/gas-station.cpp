class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int sz = gas.size();
        int ans = 0;
        int curr=0, tgas=0, tcost=0;
        for(int i=0; i<sz; i++){
            tgas += gas[i];
            tcost += cost[i];
            curr += gas[i] - cost[i];
            if(curr < 0){
                curr = 0;
                ans = i+1;
            }
        }

        return tgas<tcost ? -1 : ans;
    }
};