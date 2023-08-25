class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        if(arr[0] > arr[1]) return 0;
        for(int i=1; i<arr.size(); i++){
            int next = i+1 < arr.size() ? arr[i+1] : 0;
            if(arr[i-1] < arr[i] && next < arr[i]) return i;
        }
        return -1;
    }
};