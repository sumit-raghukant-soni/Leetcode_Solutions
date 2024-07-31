class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int sz = arr.size();

        for(int i=0; i<sz-2; i++){
            if(arr[i]&1 && arr[i+1]&1 && arr[i+2]&1) return true;
        }

        return false;
    }
};