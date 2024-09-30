class CustomStack {
public:
    int sz, top;
    vector<int> arr, lazyLoader;
    CustomStack(int maxSize) {
        sz = maxSize;
        top = -1;
        arr = vector<int>(sz, 0);
        lazyLoader = vector<int>(sz, 0);
    }
    
    void push(int x) {
        if(top+1 == sz) return;

        top++;
        arr[top] = x;
        lazyLoader[top] = 0;
    }
    
    int pop() {
        if(top == -1) return -1;
        if(top-1 >= 0){
            lazyLoader[top-1] += lazyLoader[top];
        }
        top--;
        return arr[top+1] + lazyLoader[top+1];
    }
    
    void increment(int k, int val) {
        if(top == -1) return;
        lazyLoader[min(k-1, top)] += val;
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */