class Solution {
public:
    int getLength(ListNode* l1){
        int cnt = 0;
        while(l1 != NULL){
            cnt++;
            l1 = l1->next;
        }
        return cnt;
    }
    ListNode* add(ListNode* l1, ListNode* l2){
        int carry = 0;
        ListNode* curr, *prev;
        curr = l1;
        while(curr != NULL){
            carry += curr->val;
            if(l2 != NULL) carry += l2->val;
            curr->val = carry%10;
            carry /= 10;
            prev = curr;
            curr = curr->next;
            if(l2 != NULL) l2 = l2->next;
        }
        if(carry != 0) prev->next = new ListNode(carry);
        return l1;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sz1 = getLength(l1), sz2 = getLength(l2);
        
        if(sz1 > sz2)
            return add(l1, l2);

        return add(l2, l1);
    }
};