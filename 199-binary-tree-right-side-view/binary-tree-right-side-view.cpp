class Solution {
public:
    void solve(TreeNode* root, vector<int>& ans, int i){
        if(!root) return;

        if(i == ans.size()) ans.push_back(root->val);
        else ans[i] = root->val;

        solve(root->left, ans, i+1);
        solve(root->right, ans, i+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        if(!root) return ans;

        solve(root, ans, 0);

        return ans;
    }
};