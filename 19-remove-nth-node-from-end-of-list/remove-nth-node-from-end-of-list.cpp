class Solution {
public:
    int count(ListNode* head){
        int cnt = 0;
        while(head){
            cnt++; head = head->next;
        }
        return cnt;
    }
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head) return head;
        int cnt2 = count(head);
        int cnt = cnt2 - n;
        // cout << cnt << endl;
        if(cnt == 0) return head->next; 
        ListNode* curr = head, *prev = NULL;

        while(cnt--){
            prev = curr;
            curr = curr->next;
        }
        // cout << curr->val << " ";
        prev->next = curr->next;

        return head;
    }
};