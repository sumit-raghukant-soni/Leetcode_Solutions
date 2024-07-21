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
    unordered_map<TreeNode*, pair<int, int>> mp;
    int solve(TreeNode* root, int incl){
        if(!root) return 0;
        if(mp.find(root) != mp.end()){
            if(incl && mp[root].first != -1) return mp[root].first;
            if(!incl && mp[root].second != -1) return mp[root].second;
        }
        if(incl){
            int tmp1 = root->val + solve(root->left, !incl) + solve(root->right, !incl);
            int tmp2 = solve(root->left, incl) + solve(root->right, incl);
            if(mp.find(root) == mp.end()) mp[root].second = -1;
            return mp[root].first = max(tmp1, tmp2);
        } 
        if(mp.find(root) == mp.end()) mp[root].first = -1;
        return mp[root].second = solve(root->left, !incl) + solve(root->right, !incl);
    }
    int rob(TreeNode* root) {
        return max(solve(root, 0), solve(root, 1));
    }
};