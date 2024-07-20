class Solution {
public:
    string getHint(string secret, string guess) {
        int sz = secret.size(), x = 0, y = 0;
        vector<int> bulls(sz, 0);
        unordered_map<int, int> gmp;

        for(int i=0; i<sz; i++){
            if(secret[i] == guess[i]){
                bulls[i] = 1;
                x++;
            }
        }

        for(int i=0; i<sz; i++){
            if(bulls[i]) continue;
            gmp[guess[i]]++;
        }

        for(int i=0; i<sz; i++){
            if(!bulls[i] && gmp.find(secret[i]) != gmp.end() && gmp[secret[i]] > 0){
                y++;
                gmp[secret[i]]--;
            }
        }

        return to_string(x)+"A"+to_string(y)+"B";
    }
};