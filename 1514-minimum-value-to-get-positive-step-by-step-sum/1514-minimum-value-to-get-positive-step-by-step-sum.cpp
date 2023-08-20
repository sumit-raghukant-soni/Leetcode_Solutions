class Solution {
public:
    int minStartValue(vector<int>& nums) {
        int sv = 0, sum = 0;
        
        for(auto i : nums){
            if(i<0 && abs(i) >= sum){
                sv += abs(sum+i) + 1;
                sum = 1;
            }
            else sum += i;
        }

        return sv == 0 ? 1 : sv;
    }
};