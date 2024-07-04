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
    ListNode* mergeNodes(ListNode* head) {
        ListNode *ans = new ListNode(-1), *curr = head, *tail = ans;

        while(curr){
            ListNode* tmp = new ListNode(0);
            if(curr->val == 0){
                curr = curr->next;
                while(curr && curr->val != 0){
                    tmp->val += curr->val;
                    curr = curr->next;
                }
            }
            if(curr){
                tail->next = tmp;
                tail = tail->next;
            }
        }

        return ans->next;
    }
};