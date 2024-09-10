/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode *curr = head, *next = NULL;

        while(curr){
            int a = curr->val, b;
            if(!curr->next) break;
            b = curr->next->val;
            next = curr->next;
            curr->next = new ListNode(__gcd(a, b));
            curr =curr->next;
            curr->next = next;
            curr = curr->next;
        }

        return head;
    }
};