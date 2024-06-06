class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        int sz = hand.size();
        if(sz%groupSize != 0) return false;
        map<int, int> mp;

        for(int i : hand) mp[i]++;

        while(!mp.empty()){
            auto top = mp.begin();
            int key = top->first;
            mp[key]--;
            if(mp[key] == 0) mp.erase(top->first);
            for(int i=0; i<groupSize-1; i++){
                if(mp.find(key+1) == mp.end()) return false;
                key++;
                // cout << key << " ";
                mp[key]--;
                if(mp[key] == 0) mp.erase(key);
            }
            // cout << endl;
        }

        return mp.size() == 0;
    }
};