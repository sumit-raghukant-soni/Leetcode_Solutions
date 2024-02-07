class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if(!head) return head;

        ListNode *head1 = new ListNode(-1), *tail1 = head1, *head2 = new ListNode(-1), *tail2 = head2;

        ListNode* curr = head, *next;

        while(curr){
            next = curr->next;
            if(curr->val < x){
                tail1->next = curr;
                tail1 = tail1->next;
            }
            else{
                tail2->next = curr;
                tail2 = tail2->next;
            }
            curr->next = NULL;
            curr = next;
        }

        if(tail1 == head1) return head2->next;
        tail1->next = head2->next;
        return head1->next;
    }
};