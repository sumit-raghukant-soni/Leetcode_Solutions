class Solution {
public:
    ListNode* reverse(ListNode* &head, ListNode* &next, int cnt){
        ListNode *curr = head, *prev = NULL;
        while(cnt-- && curr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        
        if(curr) head->next = curr;
        return prev;
    }
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if(!head || !head->next || left == right) return head;

        ListNode *curr = head, *prev = NULL, *next = NULL, *next2 = NULL; 
        int cnt = 1;

        while(cnt < left){
            cnt++;
            prev = curr;
            curr = curr->next;
        }

        if(left != 1) {
            next = curr;
            prev->next = reverse(curr, next2, right-left+1);
            // prev = prev->next;
            next->next = next2;
        }
        else{
            head = reverse(curr, next2, right-left+1);
            return head;
        }

        return head;
    }
};