class Solution {
public:
    int count(ListNode* head){
        int cnt = 0;
        while(head){
            cnt++;
            head = head->next;
        }
        return cnt;
    }
    ListNode* rotateRight(ListNode* head, int k) {
        if(k == 0 || head == NULL) return head;
        int sz = count(head);        
        k = k%sz;
        if(k == 0) return head;
        k = sz - k - 1;

        ListNode* curr = head;

        while(k--){
            curr = curr->next;
        }

        ListNode* newHead = curr->next, *tail = curr->next;
        curr->next = NULL;

        while(tail->next != NULL) tail = tail->next;

        tail->next = head;

        return newHead;
    }
};