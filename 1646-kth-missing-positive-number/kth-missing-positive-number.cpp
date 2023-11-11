class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        int sz = arr.size();
        int prev = 0;
        for(int i=0; i<sz; i++){
            if(arr[i] != prev+1){
                if(k - (arr[i]-prev-1) > 0) k -= (arr[i]-prev-1);
                else return prev + k;
            }
            prev = arr[i];
        }

        return prev+k;
    }
};