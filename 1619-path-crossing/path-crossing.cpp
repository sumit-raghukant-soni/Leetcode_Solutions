class Solution {
public:
    bool isPathCrossing(string path) {
        unordered_map<string, int> mp;
        int i=0, j=0;
        mp["0+0"]++;
        for(auto k : path){
            if(k == 'N') i++;
            else if(k == 'S') i--;
            else if(k == 'E') j++;
            else j--;
            string val = to_string(i) + '+' + to_string(j);
            mp[val]++;
            if(mp[val] > 1) return true;
        }

        return false;
    }
};