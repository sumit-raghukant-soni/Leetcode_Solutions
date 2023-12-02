class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL); // FAST IO
        if(head == NULL || head->next == NULL) return NULL;

        int cnt = 0;
        ListNode* curr = head;
        while(curr){
            curr = curr->next;
            cnt++;
        }
        int mid = (cnt/2) - 1;
        curr = head;
        while(mid){
            curr = curr->next;
            mid--;
        }
        curr->next = curr->next->next;
        return head;
    }
};