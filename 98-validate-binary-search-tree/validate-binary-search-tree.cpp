class Solution {
public:
    bool solve(TreeNode* root, long long mini, long long maxi){
        if(!root) return true;
        // cout << "values " << mini << " " << root->val << " " << maxi << endl;
        if(root->val <= mini || root->val >= maxi) return false;
        bool left = solve(root->left, mini, root->val), right = solve(root->right, root->val, maxi);
        // cout << root->val << " " << left << " " << right << endl;
        return left && right;
    }
    bool isValidBST(TreeNode* root) {
        if(!root) return false;

        long long mini = 1LL*INT_MIN - 1, maxi = 1LL*INT_MAX + 1;

        return solve(root, mini, maxi);        
    }
};