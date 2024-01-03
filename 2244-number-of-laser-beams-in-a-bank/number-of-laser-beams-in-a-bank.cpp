class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int ans = 0, sz = bank.size(), sz2 = bank[0].size();
        int prev = 0, curr = 0;
        for(int i=0; i<sz; i++){
            if(curr != 0) prev = curr;
            curr = 0;
            for(int j=0; j<sz2; j++){
                if(bank[i][j] == '1'){
                    ans += prev;
                    curr++;
                }
            }
        }
        return ans;
    }
};