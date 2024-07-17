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
    void solve(TreeNode*& root, unordered_map<int, int>& mp, vector<TreeNode*>& ans){
        if(!root) return;

        solve(root->left, mp, ans);
        solve(root->right, mp, ans);

        if(mp.find(root->val) != mp.end()){
            if(root->left) ans.push_back(root->left);
            if(root->right) ans.push_back(root->right);
            root = NULL;
        }
    }
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
            vector<TreeNode*> ans;
            unordered_map<int, int> mp;
            for(int i : to_delete) mp[i]++;

            solve(root, mp, ans);

            if(root && mp.find(root->val) == mp.end()) ans.push_back(root);

            return ans;
    }
};