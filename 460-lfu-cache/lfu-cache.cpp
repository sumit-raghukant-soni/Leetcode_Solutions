class LFUCache {
public:
    set<vector<int>> st;
    unordered_map<int, int> kv, kc, kj;
    int sz, i, j;
    LFUCache(int capacity) {
        i=0, j=0;
        sz = capacity;
    }
    
    int get(int key) {
        // print();
        if(kc.find(key) != kc.end()){
            int cnt = kc[key], value = kv[key], jVal = kj[key];
            kc[key] = cnt+1;
            kj[key] = ++j;
            st.erase({cnt, jVal, key, value});
            st.insert({cnt+1, j, key, value});
            return value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        // print();
        if(kv.find(key) != kv.end()){
            int cnt = kc[key], val = kv[key], jVal = kj[key];
            kc[key] = cnt + 1;
            kv[key] = value;
            kj[key] = ++j;
            st.erase({cnt, jVal, key, val});
            st.insert({cnt+1, j, key, value});
            return;
        }
        if(i == sz){
            vector<int> arr = *st.begin();
            // cout << arr[0] << " " << arr[1] << arr[2] << endl;
            kc.erase(arr[2]);
            kv.erase(arr[2]);
            kj.erase(arr[2]);
            st.erase(arr);
            i--;
        }
        i++;
        kc[key] = 1;
        kv[key] = value;
        kj[key] = j++;
        st.insert({1, j-1, key, value});
    }

    void print(){
        for(auto i = st.begin(); i != st.end(); i++){
            vector<int> arr = *i;
            cout << arr[0] << ":" << arr[1] << ":" << arr[2] << ":" << arr[3] << endl;
        }
        cout << endl;
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */