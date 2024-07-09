class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& pairs) {
        int sz = pairs.size(), i=0;
        int curr=-1, prev = -1;
        double avg = 0;

        curr = prev = pairs[i][0];

        while(i < sz){
            // cout << prev << ":" << pairs[i][1] << " " << curr << " = " << pairs[i][0] << endl;
            if(i < sz && curr >= pairs[i][0]+pairs[i][1] && prev+pairs[i][1] <= curr){
                while(i < sz && curr >= pairs[i][0]+pairs[i][1] && prev+pairs[i][1] <= curr){
                    // cout << "removed" << pairs[i][0] << ":" << pairs[i][1] << " at " << curr << endl;
                    avg += curr - pairs[i][0];
                    int tmp = prev;
                    prev = curr;
                    curr = tmp + pairs[i][1];
                    i++;
                }
            }
            else{
                // cout << "here" << endl;
                prev = curr;
                if(i < sz && pairs[i][0] > curr) curr = pairs[i][0];
                else if(i < sz) curr += pairs[i][1];
                else curr++;
            }
        }

        return avg/sz;
    }
};