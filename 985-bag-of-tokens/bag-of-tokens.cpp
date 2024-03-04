class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int sz = tokens.size();
        sort(tokens.begin(), tokens.end());
        int score = 0, maxScore=0;

        for(int i=0; i<sz; i++){
            if(tokens[i] <= power){
                // cout << "front" << endl;
                power -= tokens[i];
                score++;
            }
            else if(score > 0){
                // cout << "prev" << endl;
                score--;
                power += tokens[sz-1];
                sz--;
                i--;
            }
            maxScore = max(maxScore, score);
            // cout << tokens[i] << " " << power << " " << score << endl;
        }

        return maxScore;
    }
};