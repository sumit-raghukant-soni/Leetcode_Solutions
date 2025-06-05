class FrontMiddleBackQueue {
    int arr[] = null, f, r, sz, tmp;
    public FrontMiddleBackQueue() {
        arr = new int[3000];
        f = r = -1;
        sz = 0;
    }
    
    public void pushFront(int val) {
        if(f == -1){
            f = r = 1500;
            f++;
        }
        sz++;
        f--;
        arr[f] = val;
        print();
    }
    
    public void pushMiddle(int val) {
        if(f == -1){
            f = r = 1500;
            r--;
        }
        for(int i=r; i>=(f+((sz-1)/2)); i--){
            arr[i+1] = arr[i];
        }
        r++;
        arr[f + sz/2] = val;
        sz++;
        print();
    }
    
    public void pushBack(int val) {
        if(f == -1){
            f = r = 1500;
            r--;
        }
        sz++;
        r++;
        arr[r] = val;
        print();
    }
    
    public int popFront() {
        if(f == -1) return -1;
        tmp = arr[f];
        if(f == r){
            f = r = -1;
        }
        else f++;
        sz--;
        print();
        return tmp;
    }
    
    public int popMiddle() {
        if(f == -1) return -1;
        if(f == r){
            tmp = arr[f];
            f = r = -1;
        }
        else{
            tmp = arr[f+(sz-1)/2];
            for(int i=(f+((sz-1)/2)); i<=r; i++){
                arr[i] = arr[i+1];
            }
        }
        r--;
        sz--;
        print();
        return tmp;
    }
    
    public int popBack() {
        if(f == -1) return -1;
        int tmp = arr[r];
        if(f == r){
            f = r = -1;
        }
        else r--;
        sz--;
        print();
        return tmp;
    }

    private void print(){
        // for(int i=f; i<=r && f != -1; i++){
        //     System.out.print(arr[i] + ",");
        // }
        // System.out.println();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */