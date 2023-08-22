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

    ListNode* deleteDuplicates(ListNode* &head) {
        if(head == NULL) return head;
        int val = head->val;
        if(head->next && head->next->val == val)
            while(head->next && head->next->val == val)
                head = head->next;
        
        head->next = deleteDuplicates(head->next);
        return head;
    }
};