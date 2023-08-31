class Solution {
public:
    void find(TreeNode* root, unordered_map<int, int>& mp, map<int, vector<TreeNode*>, greater<int>>& dmp, unordered_map<TreeNode*, TreeNode*>& parent, int level){
        if(root == NULL) return;

        if(mp[root->val]){
            dmp[level].push_back(root);
        }
        if(root->left){
            parent[root->left] = root;
            find(root->left, mp, dmp, parent, level+1);
        }
        if(root->right){
            parent[root->right] = root;
            find(root->right, mp, dmp, parent, level+1);
        }
    }
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        if(to_delete.size() == 0) return {root};
        if(root == NULL) return {};

        unordered_map<int, int> mp;
        unordered_map<TreeNode*, TreeNode*> parent;
        map<int, vector<TreeNode*>, greater<int>> dmp;
        vector<TreeNode*> ans;

        for(auto i : to_delete)
            mp[i]++;
        
        if(mp.find(root->val) == mp.end()) ans.push_back(root);

        find(root, mp, dmp, parent, 0);

        for(auto i : dmp){
            for(auto j : i.second){
                if(parent[j] && parent[j]->left == j) parent[j]->left = NULL;
                else if(parent[j] && parent[j]->right == j) parent[j]->right = NULL;
                if(j->left) ans.push_back(j->left);
                if(j->right) ans.push_back(j->right);
                delete(j);
            }
        }

        return ans;
    }
};