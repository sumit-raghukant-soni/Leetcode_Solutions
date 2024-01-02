class Solution {
public:
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root == NULL) return root;

        if(root->val < key){
            root->right = deleteNode(root->right, key);
            return root;
        }        
        if(root->val > key){
            root->left = deleteNode(root->left, key);
            return root;
        }

        if(!root->right && !root->left) return NULL;
        else if(!root->left) return root->right;
        else if(!root->right) return root->left;
        else{
            TreeNode* main = root;
            TreeNode* tobeDeleted = root->right;
            while(tobeDeleted->left){
                main = tobeDeleted;
                tobeDeleted = tobeDeleted->left;
            }

            if(main == root){
                main->right = tobeDeleted->right;
            }
            else{
                main->left = tobeDeleted->right;
            }
            root->val = tobeDeleted->val;
            delete(tobeDeleted);
        }

        return root;
    }
};