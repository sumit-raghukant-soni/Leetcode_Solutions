class Solution {
public:
    void solve(TreeNode* root, int& minVal, int& prev){
        if(!root) return;
        
        solve(root->left, minVal, prev);
        // cout << root->val << ":" << prev << " ";
        if(prev == INT_MAX) prev = root->val;
        else minVal = min(minVal, root->val-prev);
        prev = root->val;
        solve(root->right, minVal, prev);

    }
    int getMinimumDifference(TreeNode* root) {
        int val = INT_MAX, last = INT_MAX;
        solve(root, val, last);
        return val;        
    }
};