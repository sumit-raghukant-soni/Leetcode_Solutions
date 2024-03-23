class Solution {
public:
    ListNode* reverse(ListNode* &head){
        if(head == NULL || head->next == NULL)
            return head;
        ListNode *prev = NULL, *next = NULL, *curr = head;
        while(curr != NULL){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    void reorderList(ListNode* head) {
        if(head->next == NULL)
            return;
        // Find mid
        ListNode *slow = head, *fast = head, *prev = NULL;
        while(fast->next != NULL){
            fast = fast->next;
            if(fast->next != NULL)
                fast = fast->next;
            prev = slow;
            slow = slow->next;
        }
        prev->next = reverse(prev->next);
        ListNode* curr = head;
        ListNode *newone = prev->next, *cnext = NULL, *nnext = NULL;
        prev->next = NULL;
        while(curr->next != NULL && newone != NULL){
            nnext = newone->next;
            cnext = curr->next;
            curr->next = newone;
            newone->next = cnext;
            curr = cnext;
            newone = nnext;
        }
        if(newone != NULL)
            curr->next = newone;
    }
};