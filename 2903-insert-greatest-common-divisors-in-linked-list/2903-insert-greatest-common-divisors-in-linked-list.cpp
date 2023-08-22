class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* &head) {
        if(head == NULL || head->next == NULL) return head;

        if(head->next){
            ListNode* tmp = new ListNode(__gcd(head->val, head->next->val));
            tmp->next = head->next;
            head->next = tmp;
            tmp->next = insertGreatestCommonDivisors(tmp->next);
        }
        return head;
    }
};