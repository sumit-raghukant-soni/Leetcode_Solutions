class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        int val = tickets[k];
        int ans = 0;
        if(val == 1){
            for(int i=0; i<=k; i++){
                ans += (tickets[i] <= val) ? tickets[i] : val;
            }    
            return ans;
        }
        for(int i=0; i<tickets.size(); i++){
                if(i<=k) ans += (tickets[i] < val) ? tickets[i] : val;
                else {
                    ans += (tickets[i] < val) ? tickets[i] : val-1;
                }
        }
        return ans;
    }
};