class OrderedStream {
public:
    int sz;
    int ptr = 0;
    vector<string> map;
    OrderedStream(int n) {
        sz = n;
        map = vector<string>(sz, "");
    }
    
    vector<string> insert(int idKey, string value) {
        int i = idKey-1;
        map[i] = value;
        vector<string> ans;
        if(i == ptr){
            while(i < sz && map[i] != ""){
                ans.push_back(map[i++]);
                ptr++;
            }
        }
        return ans;
    }
};

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream* obj = new OrderedStream(n);
 * vector<string> param_1 = obj->insert(idKey,value);
 */