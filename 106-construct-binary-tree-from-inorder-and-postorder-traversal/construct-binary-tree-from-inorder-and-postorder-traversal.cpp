class Solution {
public:
    TreeNode* solve(vector<int>& inorder, vector<int>& postorder, int s, int e, int& ind){
        if(ind < 0 || s > e) return NULL;

        TreeNode* tmp = new TreeNode(postorder[ind]);
        ind--;
        int mid = find(inorder.begin(), inorder.end(), postorder[ind+1]) - inorder.begin();
        tmp->right = solve(inorder, postorder, mid+1, e, ind);
        tmp->left = solve(inorder, postorder, s, mid-1, ind);

        return tmp;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int sz = inorder.size(), ind = sz-1;
        TreeNode* root = NULL;

        root = solve(inorder, postorder, 0, sz-1, ind);

        return root;
    }
};