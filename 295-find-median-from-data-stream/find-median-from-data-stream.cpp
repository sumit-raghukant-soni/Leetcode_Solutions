class MedianFinder {
public:
    multiset<double> st;
    int sz;
    MedianFinder() {
        sz = 0;
        st.clear();
    }

    void addNum(int num) {
        st.insert(num);
        sz++;
    }
    
    double findMedian() {
        int tmp = (sz-1)/2;
        auto it = st.begin();
        advance(it, tmp);
        double sum = *it;
        if(sz%2 == 0){
            if(++it != st.end()){
                sum += *it;
                sum = sum/2;
            }
        }
        return sum;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */