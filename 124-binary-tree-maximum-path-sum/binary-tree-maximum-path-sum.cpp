class Solution {
public:
    pair<int, int> solve(TreeNode* root, int& ans){
        if(!root) return {INT_MIN/10, INT_MIN/10};
        if(!root->left && !root->right) return {root->val, root->val};

        pair<int, int> left = solve(root->left, ans), right = solve(root->right, ans);
        int leftVal = max(left.first, left.second), rightVal = max(right.first, right.second);

        // cout << root->val << " " << leftVal << " " << rightVal << endl;
        ans = max({ans, root->val + leftVal + rightVal, leftVal, rightVal});

        return {max({root->val, root->val + max(leftVal, rightVal)}), 
        max({root->val, root->val + max(leftVal, rightVal)}) };
    }
    int maxPathSum(TreeNode* root) {
        int ans=INT_MIN;
        pair<int, int> p = solve(root, ans);
        return max({p.first, p.second, ans});
    }
};