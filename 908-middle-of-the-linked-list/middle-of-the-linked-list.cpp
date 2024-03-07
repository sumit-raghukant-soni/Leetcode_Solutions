class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        if(!head || !head->next) return head;

        ListNode *fast = head->next, *slow = head;

        while(fast && slow){
            fast = fast->next;
            slow = slow->next;
            if(fast) fast = fast->next;
        }

        return slow;
    }
};