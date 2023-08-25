class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ans;
        map<int, vector<int>> mp;
        for(int i=0; i<groupSizes.size(); i++){
            mp[groupSizes[i]].push_back(i);
        }

        for(auto i : mp){
            vector<int> tmp;
            int size = i.first, cnt = 0;
            for(int j=0; j<i.second.size(); j++){
                if(cnt++ < size)
                    tmp.push_back(i.second[j]);
                else{
                    ans.push_back(tmp);
                    tmp.clear();
                    tmp.push_back(i.second[j]);
                    cnt=1;
                }
            }
            if(tmp.size() != 0)
                ans.push_back(tmp);
        }
        return ans;
    }
};