class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        unordered_map<char, int> mp;
        for(auto i : chars) mp[i]++;
        int cnt=0;
        unordered_map<char, int> tmp;
        for(auto i : words){
            tmp = mp;
            for(int j=0; j<i.size(); j++){
                tmp[i[j]]--;
                if(tmp[i[j]] < 0) break;
                if(j == i.size()-1) cnt += i.size();
            }
        }
        return cnt;
    }
};