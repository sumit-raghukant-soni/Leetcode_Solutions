class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        ListNode *odd = new ListNode(-1), *even = new ListNode(-1);
        ListNode *otail = odd, *etail = even;
        ListNode* curr = head;
        bool isOdd = true;
        while(curr){
            if(isOdd){
                otail->next = curr;
                otail = otail->next;
            }
            else{
                etail->next = curr;
                etail = etail->next;
            }
            curr = curr->next;
            isOdd = isOdd ? false : true;
        }

        otail->next = NULL;
        etail->next = NULL;

        otail->next = even->next;
        return odd->next;
    }
};