class Solution {
public:
    void addMp(TreeNode* root, TreeNode* &parent, int target){
        if(root == NULL) return;

        addMp(root->left, root, target);
        addMp(root->right, root, target);

        if(root->val == target && root->left == NULL && root->right == NULL){
            if(parent && parent->left == root)  parent->left = NULL;
            else if(parent && parent->right == root)  parent->right = NULL;
            delete(root);
            return;
        }
    }
    TreeNode* removeLeafNodes(TreeNode* root, int target) {

        addMp(root->left, root, target);
        addMp(root->right, root, target);
        if(root && root->val == target && root->left == NULL && root->right == NULL) return NULL;
        return root;
    }
};