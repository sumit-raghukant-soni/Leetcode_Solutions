class Solution {
public:
    int countCompleteDayPairs(vector<int>& hours) {
        int sz = hours.size(), ans = 0;

        for(int i=0; i<sz; i++){
            for(int j=i+1; j<sz; j++){
                if((hours[i]+hours[j])%24 == 0) ans++;
            }
        }

        return ans;
    }
};