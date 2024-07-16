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
    void getNodePath(TreeNode* root, int& val1, int& val2, string& st, string& des, string& tmp){
        if(root == NULL || (st != "" && des != "")) return;
        if(root->val == val1){
            st = tmp;
        }
        if(root->val == val2){
            des = tmp;
        }

        tmp += "L";
        getNodePath(root->left, val1, val2, st, des, tmp);
        tmp.pop_back();
        if(st != "" && des != "") return;
        tmp += "R";
        getNodePath(root->right, val1, val2, st, des, tmp);
        tmp.pop_back();
    }
    string getDirections(TreeNode* root, int startValue, int destValue) {
        string ans = "", st = "", des = "", tmp = "";

        getNodePath(root, startValue, destValue, st, des, tmp);

        while(!st.empty() && !des.empty()){
            if(st[0] == des[0]){
                st.erase(st.begin());
                des.erase(des.begin());
            }
            else break;
        }

        ans = string(st.length(), 'U');

        for(int i=0; i<des.length(); i++){
            ans += des[i];
        }

        return ans;
    }
};