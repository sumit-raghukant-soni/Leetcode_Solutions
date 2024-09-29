class AllOne {
public:
    unordered_map<string, int> mp;
    set<pair<int, string>> set;
    
    AllOne() {}
    
    void inc(string key) {
        if(mp.find(key) != mp.end()){
            set.erase({mp[key], key});
        }
        mp[key]++;
        set.insert({mp[key], key});
        // print();
    }
    
    void dec(string key) {
        set.erase({mp[key], key});
        mp[key]--;
        if(mp[key] > 0){
            set.insert({mp[key], key});
        }
        // print();
    }
    
    string getMaxKey() {
        if(set.empty()) return "";
        // print();
        return set.rbegin()->second;   
    }
    
    string getMinKey() {
        if(set.empty()) return "";
        // print();
        return set.begin()->second;
    }

    void print(){
        for(auto i : set){
            cout << i.first << " " << i.second << endl;
        }
        cout << endl << endl;
    }
};

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne* obj = new AllOne();
 * obj->inc(key);
 * obj->dec(key);
 * string param_3 = obj->getMaxKey();
 * string param_4 = obj->getMinKey();
 */