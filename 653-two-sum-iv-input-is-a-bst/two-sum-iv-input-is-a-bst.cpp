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
    void solve(TreeNode* root, int& k, unordered_map<int, int>& mp, bool& ans){
        if(!root || ans) return;

        if(mp.find(k-root->val) != mp.end()){
            ans = true;
            return;
        }
        mp[root->val]++;

        solve(root->left, k, mp, ans);
        solve(root->right, k, mp, ans);
    }
    bool findTarget(TreeNode* root, int k) {
        unordered_map<int, int> mp;
        bool ans = false;

        solve(root, k, mp, ans);

        return ans;
    }
};