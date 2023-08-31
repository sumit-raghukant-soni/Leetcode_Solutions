class Solution {
public:
    ListNode* solve(ListNode* &head, int k){
        if(head == NULL) return NULL;
        int cnt = 0;
        ListNode *curr = head, *next = NULL, *prev = NULL, *imi = head->next;

        while(curr != NULL){
            cnt++;
            curr = curr->next;
        }
        if(cnt < k) return head;
        
        curr = head;
        for(int i=0; i<k && curr; i++){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        head->next = solve(next, k);
        return prev;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == NULL) return head;

        head = solve(head, k);

        return head;        
    }
};