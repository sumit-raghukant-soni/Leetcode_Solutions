class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        int sz1 = list1.size(), sz2 = list2.size(), mini = INT_MAX;
        vector<string> ans;
        unordered_map<string, int> mp1, mp2;

        for(int i=0; i<sz1; i++) mp1[list1[i]] = i;
        for(int i=0; i<sz2; i++) mp2[list2[i]] = i;

        for(int i=0; i<sz1; i++){
            if(mp2.find(list1[i]) != mp2.end()){
                if(mini > mp1[list1[i]] + mp2[list1[i]]) ans.clear();
                if(ans.empty() || mini >= mp1[list1[i]] + mp2[list1[i]]){
                    ans.push_back(list1[i]);
                    mini = mp1[list1[i]] + mp2[list1[i]];
                }
            }
        }

        return ans;
    }
};