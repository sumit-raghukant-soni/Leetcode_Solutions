class KthLargest {
public:
    int k;
    vector<int> nums;
    KthLargest(int k, vector<int>& nums) {
        this->k = k, this->nums = nums;
        sort(this->nums.begin(), this->nums.end(), greater<int>());
        if(nums.size() > k) this->nums = vector<int>(this->nums.begin(), this->nums.begin()+k);
    }
    
    int add(int val) {
        int j = nums.size()-1;
        if(nums.size() < k) nums.push_back(INT_MIN);
        while(j >= 0 && nums[j] < val){
            if(j+1 < k) nums[j+1] = nums[j];
            j--;
        }
        if(j+1 < nums.size()) nums[j+1] = val;

        // for(int i : nums) cout << i << " ";
        // cout << endl;

        return nums[k-1];
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */