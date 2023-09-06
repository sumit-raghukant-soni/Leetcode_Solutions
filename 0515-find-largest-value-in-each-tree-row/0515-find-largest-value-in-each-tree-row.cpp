class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        if(root == NULL) return {};

        vector<int> ans;
        int maxi = INT_MIN;
        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);

        while(!q.empty()){
            TreeNode* front = q.front();
            q.pop();
            if(front == NULL){
                if(!q.empty()){
                    front = q.front();
                    q.pop();
                    q.push(NULL);
                    ans.push_back(maxi);
                    maxi = INT_MIN;
                }
                else break;
            }
            maxi = maxi < front->val ? front->val : maxi;
            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }
        ans.push_back(maxi);
        return ans;
    }
};