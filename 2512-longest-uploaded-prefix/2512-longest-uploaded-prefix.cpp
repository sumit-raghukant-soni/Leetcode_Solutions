class LUPrefix {
public:
    int sz;
    vector<int> map;
    int op = 0, ll = 0;
    int l = 0;
    LUPrefix(int n) {
        sz = n;
        map = vector<int>(n, 0);
    }
    
    void upload(int video) {
        map[video-1] = 1;
        op++;
    }
    
    int longest() {
        if(ll == op) return l;
        int i=0, cnt = 0;
        while(i < sz && map[i] != 0){
            i++;
            cnt++;
        }
        ll = op;
        l = cnt;
        return l;
    }
};

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix* obj = new LUPrefix(n);
 * obj->upload(video);
 * int param_2 = obj->longest();
 */