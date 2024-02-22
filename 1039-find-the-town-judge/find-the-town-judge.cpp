class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        unordered_map<int, int> people, judge;

        for(auto i : trust){
            people[i[0]]++;
            judge[i[1]]++;
        }

        for(int i=1; i<=n; i++){
            if(people.find(i) == people.end() && judge[i] == n-1) return i;
        }

        return -1;
    }
};