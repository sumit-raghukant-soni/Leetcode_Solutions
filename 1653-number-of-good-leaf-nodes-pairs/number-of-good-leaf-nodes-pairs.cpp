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
    vector<int> solve(TreeNode* root, int& dis, int& ans){
        if(!root) return {};
        if(!root->left && !root->right) return {1};

        vector<int> left = solve(root->left, dis, ans), right = solve(root->right, dis, ans);
        int lsz = left.size(), rsz = right.size();
        for(int i=0; i<lsz; i++){
            for(int j=0; j<rsz; j++){
                if(left[i]+right[j] <= dis) ans++;
            }
        }

        for(int i=0; i<lsz; i++) left[i]++;
        for(int i=0; i<rsz; i++) right[i]++;

        left.insert(left.end(), right.begin(), right.end());
        return left;
    }
    int countPairs(TreeNode* root, int distance) {
        int ans = 0;

        solve(root, distance, ans);

        return ans;
    }
};