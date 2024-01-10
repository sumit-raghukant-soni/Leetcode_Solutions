class Solution {
public:
    void getParents(TreeNode* root, unordered_map<int, TreeNode*>& mp){
        if(!root) return;

        if(root->left){
            mp[root->left->val] = root;
            getParents(root->left, mp);
        }
        if(root->right){
            mp[root->right->val] = root;
            getParents(root->right, mp);
        }
    }
    TreeNode* getStart(TreeNode* root, int start){
        if(!root) return NULL;
        if(root->val == start) return root;

        TreeNode* left = getStart(root->left, start);
        TreeNode* right = getStart(root->right, start);

        return left ? left : right;
    }
    int amountOfTime(TreeNode* root, int start) {
        if(!root || (!root->left && !root->right)) return 0;
        int time=-1;
        unordered_map<int, TreeNode*> mp;
        mp[root->val] = NULL;
        getParents(root, mp);
        TreeNode* tmp = getStart(root, start);
        unordered_map<int, int> vis;
        queue<TreeNode*> q;
        q.push(tmp);
        q.push(NULL);

        while(!q.empty()){
            TreeNode* front = q.front();
            q.pop();
            if(front == NULL){
                time++;
                if(q.empty()) break;
                front = q.front();
                q.pop();
                q.push(NULL);
            }
            vis[front->val]++;
            if(front->left && vis.find(front->left->val) == vis.end()) q.push(front->left);
            if(front->right && vis.find(front->right->val) == vis.end()) q.push(front->right);
            if(mp[front->val] != NULL && vis.find(mp[front->val]->val) == vis.end()) q.push(mp[front->val]);
        }
        return time;
    }
};