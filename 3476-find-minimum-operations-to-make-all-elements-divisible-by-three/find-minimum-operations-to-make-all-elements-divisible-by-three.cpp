class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int ops = 0;

        for(int i : nums) if(i%3) ops++; 

        return ops;
    }
};