class Solution {
public:
    void findHeight(TreeNode* root, int& maxi, int curr){
        if(root->left == NULL && root->right == NULL){
            maxi = max(maxi, curr);
            return;
        }
        if(root->left)
            findHeight(root->left, maxi, curr+1);
        if(root->right)
            findHeight(root->right, maxi, curr+1);
    }
    void solve(TreeNode* root, vector<vector<string>>& ans, int low, int high, int level){
        if(root == NULL)
            return;
        int mid = low == high ? low : ((low+high) / 2);
        ans[level][mid] = to_string(root->val);
        solve(root->left, ans, low, mid-1, level+1);
        solve(root->right, ans, mid+1, high, level+1);
    }
    vector<vector<string>> printTree(TreeNode* root) {
        int height=0;
        findHeight(root, height, 0);
        int cols = pow(2, height+1) - 1;
        vector<vector<string>> ans(height+1, vector<string>(cols));
        solve(root, ans, 0, cols-1, 0);
        return ans;
    }
};