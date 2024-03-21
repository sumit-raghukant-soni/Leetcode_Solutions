class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(!head) return head;
        ListNode *curr = head, *next = NULL, *prev = NULL;

        while(curr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
};