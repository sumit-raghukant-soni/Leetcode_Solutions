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
    int getLength(ListNode* head){
        int cnt = 0;
        while(head){
            head = head->next;
            cnt++;
        }
        return cnt;
    }
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || !head->next || k == 0) return head;
        int sz = getLength(head);
        int moves = sz - (k%sz);
        if(moves == 0 || moves == sz) return head;

        ListNode* curr = head, *prev = NULL;
        while(moves--){
            prev = curr;
            curr = curr->next;
        }

        ListNode* newHead = curr;
        prev->next = NULL;

        while(curr->next) curr = curr->next;
        curr->next = head;

        return newHead;
    }
};