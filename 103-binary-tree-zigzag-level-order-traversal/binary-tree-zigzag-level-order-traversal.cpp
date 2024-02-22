class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> ans(1, vector<int>());
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);

        TreeNode* front = NULL;
        int ind = 0;
        while(!q.empty()){
            front = q.front();
            q.pop();
            if(front == NULL){
                if(q.empty()) break;
                front = q.front();
                q.push(NULL);
                q.pop();
                ans.push_back({});
                ind++;
            }
            if(ind&1) ans[ind].insert(ans[ind].begin(), front->val);
            else ans[ind].push_back(front->val);

            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }

        return ans;
    }
};