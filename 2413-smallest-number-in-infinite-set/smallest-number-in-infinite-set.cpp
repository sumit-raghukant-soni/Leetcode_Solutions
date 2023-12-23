class SmallestInfiniteSet {
public:
    int lastMax;
    set<int> st;
    SmallestInfiniteSet() {
        lastMax = 0;
        add();
    }
    
    void add(){
        for(int i = lastMax+1; i <= lastMax + 1000; i++){
            st.insert(i);
        }
        lastMax += 1000;
    }

    int popSmallest() {
        if(st.size() == 0) add();
        int tmp = *st.begin();
        st.erase(st.begin());
        return tmp;
    }
    
    void addBack(int num) {
        st.insert(num);
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */