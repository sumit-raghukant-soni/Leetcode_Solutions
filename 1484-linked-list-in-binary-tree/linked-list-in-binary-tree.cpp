/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    bool check(ListNode* head, int& sz, vector<TreeNode*> vis){
        int i= vis.size()-1, diff = vis.size() - sz;
        if(vis.size() < sz) return false;

        while(head && i >= diff){
            // cout << vis[i]->val << " ";
            if(head->val != vis[i]->val){
                // cout << endl;
                return false;
            }
            i--;
            head = head->next;
        }
        // cout << endl;

        return i == diff-1 && !head;
    }
    bool solve(ListNode* head, int& sz, TreeNode* root, vector<TreeNode*>& vis){
        if(!root) return false;

        vis.push_back(root);
        if(check(head, sz, vis)) return true;
        
        bool left = solve(head, sz, root->left, vis);
        bool right = solve(head, sz, root->right, vis);

        vis.pop_back();

        return left || right;
    }
    bool isSubPath(ListNode* head, TreeNode* root) {
        bool ans = false;
        vector<TreeNode*> vis;
        int sz = 0;
        ListNode* curr = head, *prev = NULL, *next = NULL;

        while(curr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
            sz++;
        }

        ans = solve(prev, sz, root, vis);

        return ans;
    }
};