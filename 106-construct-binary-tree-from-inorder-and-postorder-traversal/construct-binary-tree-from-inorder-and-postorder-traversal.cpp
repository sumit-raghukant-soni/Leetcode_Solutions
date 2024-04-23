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
    TreeNode* solve(vector<int>& postorder, vector<int>& inorder, int& sz, int& ind, int s, int e){
        if(ind < 0 || s > e) return NULL;

        int mid = find(inorder.begin(), inorder.end(), postorder[ind]) - inorder.begin();

        TreeNode* root = new TreeNode(postorder[ind]);
        ind--;
        root->right = solve(postorder, inorder, sz, ind, mid+1, e);
        root->left = solve(postorder, inorder, sz, ind, s, mid-1);

        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int sz = postorder.size(), ind = sz-1;
        return solve(postorder, inorder, sz, ind, 0, sz-1);
    }
};