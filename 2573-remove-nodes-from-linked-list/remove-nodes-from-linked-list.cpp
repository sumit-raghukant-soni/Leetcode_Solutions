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
class Solution {
public:
    int solve(ListNode* root){
        if(!root) return INT_MIN;

        int tmp = solve(root->next);
        if(tmp > root->val){
            root->val = root->next->val;
            root->next = root->next->next;
        }
        return max(root->val, tmp);
    }
    ListNode* removeNodes(ListNode* head) {
        ListNode* tmp = new ListNode(INT_MAX);
        tmp->next = head;
        head = tmp;
        solve(head);
        return head->next;
    }
};