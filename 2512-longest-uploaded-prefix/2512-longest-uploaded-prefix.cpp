class LUPrefix {
public:
    int sz;
    vector<bool> map;
    int ptr = 0;
    LUPrefix(int n) {
        sz = n;
        map = vector<bool>(n, false);
    }
    
    void upload(int video) {
        int i = video-1;
        map[i] = true;
        if(i == ptr){
            i++;
            ptr++;
            while(i < sz && map[i] != false){
                i++;
                ptr++;
            }
        }
    }
    
    int longest() {
        return ptr;
    }
};

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix* obj = new LUPrefix(n);
 * obj->upload(video);
 * int param_2 = obj->longest();
 */