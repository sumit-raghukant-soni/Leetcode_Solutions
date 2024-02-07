class Solution {
public:
    ListNode* solve(ListNode* head){
        if(!head || !head->next || head->next->val != head->val) return head;
        int val = head->val;
        while(head && head->val == val) head = head->next;
        return solve(head);
    }
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *curr = new ListNode(-1), *prev = curr, *newHead = prev;
        curr->next = head;
        
        while(prev){
            prev->next = solve(curr->next);
            prev = prev->next;
            curr = prev;
        }

        return newHead->next;
    }
};