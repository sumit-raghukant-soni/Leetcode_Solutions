class Solution {
public:
    void getCombinations(string tiles, int sz, unordered_map<string, int>& mp, string tmp, int ind){
        if(ind == sz){
            if(tmp != "") mp[tmp]++;
            return;
        }

        getCombinations(tiles, sz, mp, tmp, ind+1);
        tmp += tiles[ind];
        getCombinations(tiles, sz, mp, tmp, ind+1);
    }
    void getPermutations(string tile, unordered_map<string, int>& mp, int s, int e){
        if(s == e){
            mp[tile]++;
            return;
        }

        for(int i=s; i < e; i++){
            swap(tile[s], tile[i]);
            getPermutations(tile, mp, i+1, e);
            swap(tile[s], tile[i]);
        }
    }
    int numTilePossibilities(string tiles) {
        unordered_map<string, int> mp;
        int sz = tiles.length();

        getCombinations(tiles, sz, mp, "", 0);

        for(int i=0; i<tiles.length(); i++){
            for(auto i : mp){
                getPermutations(i.first, mp, 0, i.first.length());
            }
        }
        
        return mp.size();
    }
};