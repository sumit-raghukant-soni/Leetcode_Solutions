class Solution {
public:
    bool solve(TreeNode* root, TreeNode* p, TreeNode* q, TreeNode* &ans){
        if(!root || ans) return false;
        
        bool left = solve(root->left, p, q, ans);
        bool right = solve(root->right, p, q, ans);
        bool r = (root == p) || (root == q);
        // cout << root->val << " " << (left ? "left" : "No") << (r ? "root" : "No") << (right ? "right" : "No") << endl;
        if((left && right) || (left && r) || (right && r)) ans = root;

        return root == p || root == q || left || right;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* ans = NULL;

        solve(root, p, q, ans);

        return ans;        
    }
};