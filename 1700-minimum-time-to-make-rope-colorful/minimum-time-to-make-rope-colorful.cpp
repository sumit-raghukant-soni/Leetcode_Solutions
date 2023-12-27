class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        int ans = 0, sz = colors.length();

        for(int i=0; i<sz; i++){
            int tmp = neededTime[i], j=i, sum = tmp;
            while(j+1 < sz && colors[j] == colors[j+1]){
                j++;
                sum += neededTime[j];
                tmp = max(neededTime[j], tmp);
            }
            if(i != j){
                i = j-1;
                ans += sum - tmp;
            }
        }

        return ans;
    }
};