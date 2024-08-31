/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*> solve(vector<vector<vector<TreeNode*>>>& dp, int s, int e){
        if(s > e) return {NULL};

        vector<TreeNode*> ans;

        if(!dp[s][e].empty()) return dp[s][e];

        for(int i=s; i<=e; i++){
            auto left = solve(dp, s, i-1);
            auto right = solve(dp, i+1, e);
            for(auto leftTree : left){
                for(auto rightTree : right){
                    TreeNode* root = new TreeNode(i);
                    root->left = leftTree;
                    root->right = rightTree;
                    ans.push_back(root);
                }
            }
        }

        return dp[s][e] = ans;
    }
    vector<TreeNode*> generateTrees(int n) {
        vector<vector<vector<TreeNode*>>> dp(n+1, vector<vector<TreeNode*>>(n+1));
        return solve(dp, 1, n);
    }
};