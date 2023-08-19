class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        vector<int> ans = nums;

        for(int i=0; i<ans.size(); i++){
            if(i+1 < ans.size() && ans[i] == ans[i+1]){
                ans[i] *= 2;
                ans[i+1] = 0;
            }
        }      
        int zero=0, non;
        while(zero < ans.size() && non < ans.size()){
            while(zero < ans.size() && ans[zero] != 0) zero++;
            non = zero;
            while(non < ans.size() && ans[non] == 0) non++;
            if(zero < ans.size() && non < ans.size()){
                swap(ans[non], ans[zero++]);
            }
        }
        return ans;
    }
};