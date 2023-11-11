class Solution {
public:
    int findKOr(vector<int>& nums, int k) {
        int sz = nums.size(), ans = 0;
        int arr[32] = {0};

        for(auto i : nums){
            int tmp = i, j = 0;
            while(tmp > 0){
                if((tmp&1) == 1) arr[j]++;
                j++;
                tmp = tmp >> 1;
            }
        }

        for(int i=0; i<32; i++){
            if(arr[i] >= k) ans += pow(2, i);
        }

        return ans;
    }
};