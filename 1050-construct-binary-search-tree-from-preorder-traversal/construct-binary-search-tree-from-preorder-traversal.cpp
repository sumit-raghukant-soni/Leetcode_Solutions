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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        stack<TreeNode*> st;
        int sz = preorder.size();
        TreeNode* root = new TreeNode(preorder[0]), *tmp = NULL;
        st.push(root);

        for(int i=1; i<sz; i++){
            tmp = new TreeNode(preorder[i]);
            if(preorder[i] < st.top()->val){
                st.top()->left = tmp;
            }
            else{
                TreeNode* curr = st.top();
                st.pop();
                while(!st.empty() && st.top()->val < preorder[i]){
                    curr = st.top();
                    st.pop();
                }
                curr->right = tmp;
            }
            st.push(tmp);
        }

        return root;
    }
};