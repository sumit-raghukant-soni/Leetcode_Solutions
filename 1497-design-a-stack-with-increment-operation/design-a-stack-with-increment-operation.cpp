class CustomStack {
public:
    int sz, top;
    vector<int> arr;
    CustomStack(int maxSize) {
        sz = maxSize;
        top = -1;
        arr = vector<int>(sz, 0);
    }
    
    void push(int x) {
        if(top+1 == sz) return;

        top++;
        arr[top] = x;
    }
    
    int pop() {
        if(top == -1) return -1;
        top--;
        return arr[top+1];
    }
    
    void increment(int k, int val) {
        if(top == -1) return;
        transform(arr.begin(), arr.begin()+min(top+1, k), arr.begin(), [val](int i){
            return i + val;
        });
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */