class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(!root) return {};
        int ind=0;
        vector<vector<int>> ans(1, vector<int>());
        queue<TreeNode*> q;
        TreeNode* front = NULL;
        q.push(root);
        q.push(NULL);

        while(!q.empty()){
            front = q.front();
            q.pop();
            if(front == NULL){
                ind++;
                if(q.empty() == true) break;
                ans.push_back({});
                front = q.front();
                q.pop();
                q.push(NULL);
            }
            ans[ind].push_back(front->val);
            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }

        return ans;        
    }
};