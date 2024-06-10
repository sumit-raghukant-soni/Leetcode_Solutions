class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        int sz = plants.size(), tcap = capacity;
        int steps = 0;

        for(int i=0; i<sz; i++){
            if(tcap < plants[i]){
                steps+= (i+1) + i;
                tcap = capacity - plants[i];
            }
            else{
                steps++;
                tcap -= plants[i];
            }
        }

        return steps;
    }
};