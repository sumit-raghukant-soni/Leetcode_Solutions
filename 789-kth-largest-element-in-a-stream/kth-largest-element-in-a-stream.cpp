class KthLargest {
public:
    int k;
    vector<int> nums;
    KthLargest(int k, vector<int>& nums) {
        this->k = k, this->nums = nums;
        sort(this->nums.begin(), this->nums.end());
    }
    
    int add(int val) {
        int j = nums.size()-1;
        nums.push_back(INT_MAX);
        while(j >= 0 && nums[j] > val){
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = val;

        // for(int i : nums) cout << i << " ";
        // cout << endl;

        return nums[nums.size()-k];
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */