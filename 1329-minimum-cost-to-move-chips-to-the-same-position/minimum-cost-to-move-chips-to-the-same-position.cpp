class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
        int sz = position.size(), evenPlace = 0, oddPlace = 0;

        for(int i=0; i<sz; i++){
            if(position[i]&1) oddPlace++;
            else evenPlace++;
        }

        return oddPlace < evenPlace ? oddPlace : evenPlace;
    }
};