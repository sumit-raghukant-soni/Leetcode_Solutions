class MyQueue {
public:
    stack<int> st;
    stack<int> pst;
    MyQueue() {
        
    }
    
    void push(int x) {
        st.push(x);
    }

    void transfer(){
        if(pst.size() == 0){
            while(st.size()){
                pst.push(st.top());
                st.pop();
            }
        }
    }
    
    int pop() {
        transfer();
        int val = pst.top();
        pst.pop();
        return val;
    }
    
    int peek() {
        transfer();
        return pst.top();
    }
    
    bool empty() {
        return st.empty() && pst.empty();
    }
};