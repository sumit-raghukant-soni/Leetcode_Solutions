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
    void getInorder(TreeNode* root, vector<int>& inorder){
        if(!root) return;

        getInorder(root->left, inorder);
        inorder.push_back(root->val);
        getInorder(root->right, inorder);
    }
    void solve(TreeNode*& root, vector<int>& inorder, int& ind){
        if(!root) return;

        solve(root->left, inorder, ind);
        if(root->val != inorder[ind]) root->val = inorder[ind];
        ind++;
        solve(root->right, inorder, ind);
    }
    void recoverTree(TreeNode* root) {
        vector<int> inorder;
        getInorder(root, inorder);
        sort(inorder.begin(), inorder.end());
        
        int ind = 0;
        solve(root, inorder, ind);
    }
};