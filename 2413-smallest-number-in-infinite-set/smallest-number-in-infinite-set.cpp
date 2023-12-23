class SmallestInfiniteSet {
public:
    int lastMax, mini;
    set<int> st;
    SmallestInfiniteSet() {
        lastMax = 0;
        mini = 1;
    }

    int popSmallest() {
        if(st.size() == 0 || *st.begin() > mini) return mini++;
        int tmp = *st.begin();
        st.erase(st.begin());
        return tmp;
    }
    
    void addBack(int num) {
        if(num < mini) st.insert(num);
    }
};