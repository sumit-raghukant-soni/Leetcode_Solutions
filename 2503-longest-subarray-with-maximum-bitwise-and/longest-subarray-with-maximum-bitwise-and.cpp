class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int sz = nums.size(), maxi = 0, cnt = 0;

        for(int i=0; i<sz; i++){
            int j=i, tmp = 0;
            while(j < sz && nums[i] == nums[j]){
                tmp++; j++;
            }
            if(maxi < nums[i]){
                maxi = nums[i];
                cnt = tmp;       
            }
            else if(maxi == nums[i]) cnt = max(cnt, tmp);
            j--;
            i = j;
        }

        return cnt;
    }
};