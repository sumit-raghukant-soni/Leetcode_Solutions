class Solution {
public:
    int solve(TreeNode* root, int& ans, string dir, int tmp){
        if(!root) return 0;

        if(!root->left && !root->right){
            ans = max(tmp, ans);
            return 1;
        }

        int left = 0, right = 0;
        if(dir == ""){
            left = solve(root->left, ans, "right", 1);
            right = solve(root->right, ans, "left", 1);
        }
        else if(dir == "left"){
            left = solve(root->left, ans, "right", tmp + 1);
            right = solve(root->right, ans, "left", 1);
        }
        else{
            left = solve(root->left, ans, "right", 1);
            right = solve(root->right, ans, "left", tmp + 1);
        }

        cout << root->val << dir << " " << tmp << " " << ans << endl;
        ans = max(ans, tmp);
        return 1 + max(left, right);
    }
    int longestZigZag(TreeNode* root) {
        if(!root) return 0;
        
        int ans = 0;
        solve(root, ans, "", 0);

        return ans;
    }
};