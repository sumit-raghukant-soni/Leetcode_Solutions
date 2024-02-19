class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        vector<double> ans;
        double tmp = 0, cnt = 0;
        TreeNode* front = NULL;
        
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);

        while(!q.empty()){
            front = q.front();
            q.pop();
            if(front == NULL){
                ans.push_back(tmp/cnt);
                if(q.empty()) break;
                front = q.front();
                q.pop();
                q.push(NULL);
                tmp = cnt = 0;
            }
            tmp += front->val;
            cnt++;
            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }

        return ans;
    }
};