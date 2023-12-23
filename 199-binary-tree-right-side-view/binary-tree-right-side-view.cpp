class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return {};
        vector<int> ans;
        ans.push_back(root->val);

        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);

        while (!q.empty()) {
            TreeNode* tmp = q.front();
            q.pop();
            if (tmp == NULL) {
                if (q.empty())
                    break;
                else {
                    tmp = q.front();
                    q.pop();
                    q.push(NULL);
                    ans.push_back(tmp->val);
                }
            }
            
            if (tmp->right)
                q.push(tmp->right);
            if (tmp->left != NULL)
                q.push(tmp->left);   
        }

        return ans;
    }
};