class Solution {
public:
    void solve(TreeNode* root, int& low, int& high, int& sum){
        if(!root) return;

        if(root->val <= high && root->val >= low){
            sum += root->val;
            if(root->val <= high) solve(root->left, low, high, sum);
            if(root->val >= low) solve(root->right, low, high, sum);
        }
        else if(root->val < low) solve(root->right, low, high, sum);
        else if(root->val > high) solve(root->left, low, high, sum);
    }
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;

        solve(root, low, high, sum);

        return sum;        
    }
};