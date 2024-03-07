class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(!head || !head->next) return false;

        ListNode *fast = head->next, *slow = head;        

        while(fast && slow){
            if(fast == slow) return true;
            fast = fast->next;
            slow = slow->next;
            if(fast) fast = fast->next;
        }

        return false;
    }
};