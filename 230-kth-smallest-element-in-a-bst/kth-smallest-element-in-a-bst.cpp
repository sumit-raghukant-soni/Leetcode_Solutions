class Solution {
public:
    void solve(TreeNode* root, int k, int& ind, int& ans){
        if(!root) return;
        solve(root->left, k, ind, ans);
        ind++;
        if(ind == k && ans == -1) ans = root->val;
        if(ind < k){
            solve(root->right, k, ind, ans);
        }
    }
    int kthSmallest(TreeNode* root, int k) {
        int ind = 0, ans=-1;
        solve(root, k, ind, ans);
        return ans;
    }   
};