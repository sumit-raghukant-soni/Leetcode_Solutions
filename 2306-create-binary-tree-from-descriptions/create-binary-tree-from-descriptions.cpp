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
    class NNode{
        public:
        int val;
        NNode *parent, *left, *right;
        NNode(int v){
            this->val = v;
            parent = left = right = NULL;
        }
    };
    TreeNode* createBinaryTree(vector<vector<int>>& desc) {
        int sz = desc.size();
        unordered_map<int, TreeNode*> mp;
        unordered_map<TreeNode*, int> p, c;

        for(int i=0; i<sz; i++){
            TreeNode* parent = mp.find(desc[i][0]) != mp.end() ? mp[desc[i][0]] : new TreeNode(desc[i][0]);
            TreeNode* child = mp.find(desc[i][1]) != mp.end() ? mp[desc[i][1]] : new TreeNode(desc[i][1]);

            if(desc[i][2]) parent->left = child;
            else parent->right = child;
            // cout << parent->val << " " << child->val << endl;
            p[parent]++;
            c[child]++;
            mp[parent->val] = parent;
            mp[child->val] = child;
        }

        for(auto i : p){
            // cout << i.first->val << " " << i.second << endl;
            if(c.find(i.first) == c.end()) return i.first;
        }

        return NULL;
    }
};