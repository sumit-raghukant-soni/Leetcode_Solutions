class RandomizedSet {
public:
    unordered_map<int, int> mp;
    unordered_map<int, int>::iterator itr;
    int sz;
    RandomizedSet() {
        sz = 0;
    }
    
    bool insert(int val) {
        if(mp.find(val) != mp.end()) return false;
        mp[val]++;
        sz++;
        return true;
    }
    
    bool remove(int val) {
        if(mp.find(val) == mp.end()) return false;
        mp.erase(val);
        sz--;
        return true;
    }
    
    int getRandom() {
        itr = next(mp.begin(), rand()%sz);
        return itr->first;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */