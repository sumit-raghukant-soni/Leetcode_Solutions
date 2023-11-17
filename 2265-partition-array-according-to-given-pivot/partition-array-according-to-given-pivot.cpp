class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        int cnt=0;
        int sz = nums.size();
        vector<int> low, high;
        for(int i : nums){
            if(i < pivot) low.push_back(i);
            else if(i > pivot) high.push_back(i);
            else cnt++;
        }

        for(int i=0; i<cnt; i++) low.push_back(pivot);

        low.insert(low.end(), high.begin(), high.end());
        return low;
    }
};