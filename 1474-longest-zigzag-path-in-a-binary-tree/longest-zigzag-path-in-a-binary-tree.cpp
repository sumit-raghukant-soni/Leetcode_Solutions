class Solution {
public:
    int solve(TreeNode* root, int& ans, int dir, int tmp){
        if(!root) return 0;

        if(!root->left && !root->right){
            ans = max(tmp, ans);
            return 1;
        }

        int left = 0, right = 0;
        if(dir == -1){
            left = solve(root->left, ans, 1, 1);
            right = solve(root->right, ans, 0, 1);
        }
        else if(dir == 0){
            left = solve(root->left, ans, 1, tmp + 1);
            right = solve(root->right, ans, 0, 1);
        }
        else{
            left = solve(root->left, ans, 1, 1);
            right = solve(root->right, ans, 0, tmp + 1);
        }

        ans = max(ans, tmp);
        return 1 + max(left, right);
    }
    int longestZigZag(TreeNode* root) {
        if(!root) return 0;
        
        int ans = 0;
        solve(root, ans, -1, 0);

        return ans;
    }
};