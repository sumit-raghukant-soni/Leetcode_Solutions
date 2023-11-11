class Solution {
public:
    int countHillValley(vector<int>& nums) {
        int sz = nums.size();
        int s = 0, e = sz-1;
        int tmp = nums[0], cnt = 0;
        while(s <= e && nums[s] == tmp) s++;
        tmp = nums[e];
        while(e >= 0 && nums[e] == tmp) e--;

        while(s <= e){
            if(s-1 >= 0 && s+1 < sz){
                int prev = nums[s-1], curr = nums[s];
                while(s <= e && nums[s] == curr) s++;
                if(s < sz && nums[s] != curr) s--;
                if(prev < nums[s] && s+1 < sz && nums[s+1] < nums[s]) cnt++;
                else if(prev > nums[s] && s+1 < sz && nums[s+1] > nums[s]) cnt++;
            }
            s++;
        }

        return cnt;
    }
};