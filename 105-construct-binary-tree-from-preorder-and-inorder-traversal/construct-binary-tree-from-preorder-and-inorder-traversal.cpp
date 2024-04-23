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
    TreeNode* solve(vector<int>& preorder, vector<int>& inorder, int& sz, int& ind, int s, int e){
        if(ind == sz || s > e) return NULL;

        int mid = find(inorder.begin(), inorder.end(), preorder[ind]) - inorder.begin();
        
        TreeNode* root = new TreeNode(preorder[ind]);
        ind++;
        root->left = solve(preorder, inorder, sz, ind, s, mid-1);
        root->right = solve(preorder, inorder, sz, ind, mid+1, e);

        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int sz = preorder.size(), ind = 0;
        return solve(preorder, inorder, sz, ind, 0, sz-1);
    }
};