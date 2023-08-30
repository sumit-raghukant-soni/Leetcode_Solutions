class MyStack {
public:
    queue<int> q;
    MyStack() {
        // queue<int> q;
    }
    void rev(){
        if(q.size() == 1) return;
        int val = q.front();
        q.pop();
        rev();
        q.push(val);
    }
    void push2(int x){
        if(q.empty()){
            q.push(x);
            return;
        }
        int val = q.front();
        q.pop();
        push2(x);
        q.push(val);
    }
    void push(int x) {
        if(!q.empty()) rev();
        push2(x);
    }
    
    int pop() {
        if(q.empty())
            return -1;
        int val = q.front();
        q.pop();
        return val;
    }
    
    int top() {
        return q.front();
    }
    
    bool empty() {
        return q.size() == 0;
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */