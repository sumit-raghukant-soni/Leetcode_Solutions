class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        set<int> st;
        for(int i : nums){
            if(i > 0){
                st.insert(i);
            }
        }
        int val = 1;
        while(!st.empty()){
            if(*st.begin() != val) return val;
            else val++;
            st.erase(st.begin());
        }

        return val;
    }
};