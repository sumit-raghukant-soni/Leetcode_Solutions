class Solution {
public:
    void solve(TreeNode* root, int& ans, int maxi){
        if(root == NULL) return;

        if(maxi <= root->val) ans++;
        solve(root->left, ans, max(maxi, root->val));
        solve(root->right, ans, max(maxi, root->val));
    }
    int goodNodes(TreeNode* root) {
        ios_base::sync_with_stdio(false); cin.tie(NULL);cout.tie(NULL);
        if(root == NULL) return {};

        int ans = 0;
        solve(root, ans, root->val);

        return ans;        
    }
};