class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        int arr[101] = {0};
        int sz = nums.size(), ind = nums[0];

        for(int i=0; i<sz; i++){
            arr[nums[i]]++;
            if(arr[ind] < arr[nums[i]]) ind = nums[i];
        }

        int ans = 0;
        for(int i=0; i<sz; i++){
            // cout << arr[nums[i]] << " " << nums[i] << " " << arr[ind] << endl;
            if(arr[nums[i]] == arr[ind]) ans++;
        }

        return ans;
    }
};