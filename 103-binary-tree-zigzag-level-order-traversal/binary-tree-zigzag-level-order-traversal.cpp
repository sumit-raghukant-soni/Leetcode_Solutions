/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(!root) return {};
        vector<vector<int>> ans;
        vector<int> tmp;

        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        TreeNode* front = NULL;

        bool dir = 1;

        while(!q.empty()){
            front = q.front();
            q.pop();
            
            if(!front){
                ans.push_back(tmp);
                tmp.clear();
                if(q.empty()) break;
                else{
                    front = q.front();
                    q.pop();
                    q.push(NULL);
                    dir = !dir;
                }
            }
            
            if(dir) tmp.push_back(front->val);
            else tmp.insert(tmp.begin(), front->val);

            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }

        return ans;
    }
};