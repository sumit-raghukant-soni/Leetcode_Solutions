class RandomizedSet {
public:
    unordered_map<int, int> mp;
    unordered_map<int, int>::iterator itr;
    RandomizedSet() {
        itr = mp.begin();
    }
    
    bool insert(int val) {
        if(mp.find(val) == mp.end()){
            mp[val]++;
            return true;
        }
        return false;
    }
    
    bool remove(int val) {
        if(mp.find(val) == mp.end()) return false;
        mp.erase(val);
        return true;
    }
    
    int getRandom() {
        itr = mp.begin();
        itr = next(itr, rand()%mp.size());
        return itr->first;
    }
};