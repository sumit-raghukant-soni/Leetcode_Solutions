class Solution {
public:
    ListNode* solve(ListNode* &head, ListNode* &next, int k){
        ListNode *curr = head, *prev = NULL;
        while(curr && k--){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    int count(ListNode* head){
        int cnt = 0;
        while(head){
            head = head->next;
            cnt++;
        }
        return cnt;
    }
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* curr = new ListNode(-1), *next = NULL, *prev = NULL;
        int sz = count(head);

        curr->next = head;
        head = curr;
        prev = head;

        while(curr && sz >= k){
            curr = prev->next;
            prev->next = solve(curr, next, k);
            if(curr) curr->next = next;
            prev = curr;
            sz -= k;
        }

        return head->next;        
    }
};