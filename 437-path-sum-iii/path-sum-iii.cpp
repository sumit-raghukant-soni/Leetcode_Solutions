class Solution {
public:
    void solve(TreeNode* root, int& ans, int& target, vector<int> prev){
        if(root == NULL) return;

        long long tmp = 0;
        prev.push_back(root->val);
        int sz = prev.size();

        for(int i=sz-1; i>=0; i--){
            tmp += prev[i];
            if(tmp == target) ans++;
        }

        solve(root->left, ans, target, prev);
        solve(root->right, ans, target, prev);
    }
    int pathSum(TreeNode* root, int targetSum) {
        int ans = 0;

        solve(root, ans, targetSum, {});

        return ans;
    }
};