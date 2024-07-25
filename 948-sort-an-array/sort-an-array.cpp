class Solution {
public:
    void merge(vector<int>& nums, int s, int mid, int e){
        int k = 0, s1 = s, s2 = mid+1;
        int v1, v2;
        vector<int> tmp(e-s+1);

        while(s1 <= mid || s2 <= e){
            v1 = v2 = INT_MAX;
            if(s1 <= mid) v1 = nums[s1];
            if(s2 <= e) v2 = nums[s2];

            if(v1 < v2) s1++;
            else s2++;
            tmp[k++] = min(v1, v2);
        }

        for(int i=s; i<=e; i++){
            nums[i] = tmp[i-s];
        }
    }
    void mergeSort(vector<int>& nums, int s, int e){
        if(s == e) return;

        int mid = s + (e-s)/2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid+1, e);
        merge(nums, s, mid, e);
    }
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums, 0, nums.size()-1);

        return nums;
    }
};