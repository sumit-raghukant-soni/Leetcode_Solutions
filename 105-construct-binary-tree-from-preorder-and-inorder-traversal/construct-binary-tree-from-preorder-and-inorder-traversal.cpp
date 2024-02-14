class Solution {
public:
    TreeNode* solve(vector<int>& preorder, vector<int>& inorder, int s, int e, int& ind, int sz){
        // if(ind < sz) cout << preorder[ind] << s << " " << e << endl;
        if(ind >= sz || s > e) return NULL;

        if(s == e) return new TreeNode(preorder[ind++]);

        TreeNode* tmp = new TreeNode(preorder[ind]);
        int mid = find(inorder.begin(), inorder.end(), preorder[ind]) - inorder.begin();
        ind++;
        tmp->left = solve(preorder, inorder, s, mid-1, ind, sz);
        tmp->right = solve(preorder, inorder, mid+1, e, ind, sz);

        return tmp; 
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        TreeNode* root = new TreeNode(preorder[0]);

        int s = 0, sz = inorder.size(), ind = 1;
        int mid = find(inorder.begin(), inorder.end(), preorder[0]) - inorder.begin();
        root->left = solve(preorder, inorder, s, mid-1, ind, sz);
        root->right = solve(preorder, inorder, mid+1, sz-1, ind, sz);

        return root;        
    }
};