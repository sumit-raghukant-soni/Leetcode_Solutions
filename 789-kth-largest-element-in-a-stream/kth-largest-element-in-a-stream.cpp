class KthLargest {
public:
    vector<int> maxList;
    int sz, ind;
    KthLargest(int k, vector<int>& nums) {
        maxList = vector<int>(k, INT_MIN);
        sz = k, ind = -1;

        for(int i : nums){
            add(i);
        }
        // print();
    }
    
    int add(int val) {
        if(ind == -1){
            ind++;
            maxList[ind] = val;
            return val;
        }
        if(ind == sz-1 && val < maxList[ind]) return maxList[ind];
        
        if(ind < sz-1) ind++;
        int tmp = ind-1;
        while(tmp >= 0 && maxList[tmp] < val){
            if(tmp+1 < sz) maxList[tmp+1] = maxList[tmp];
            tmp--;
        }
        // cout << ind << ":" << tmp+1 << endl;
        if(tmp+1 < sz) maxList[tmp+1] = val;
        
        // print();
        return maxList[ind];
    }

    void print(){
        for(int i : maxList) cout << i << " ";
        cout << endl;
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */