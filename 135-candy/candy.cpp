class Solution {
public:
    int candy(vector<int>& ratings) {
        int cnt = 0, sz = ratings.size();
        vector<int> tmp(sz, 1);

        for(int i=0; i<sz; i++){
            if(i-1 >= 0 && ratings[i-1] < ratings[i]) tmp[i] += tmp[i-1];
        }

        // for(int i : tmp) cout << i << " ";
        // cout << endl;

        for(int i=sz-1; i>=0; i--){
            if(i+1 < sz && ratings[i+1] < ratings[i] && tmp[i+1] >= tmp[i]) tmp[i] = tmp[i+1] + 1;
            cnt += tmp[i];
        }

        // for(int i : tmp) cout << i << " ";
        // cout << endl;

        return cnt;
    }
};