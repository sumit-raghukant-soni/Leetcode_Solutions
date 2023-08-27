class Solution {
public:
    int find(ListNode* &curr){
        if(curr == NULL) return 0;
        int sum = 0;
        while(curr->val != 0){
            sum += curr->val;
            curr = curr->next;
        }
        return sum;
    }
    ListNode* mergeNodes(ListNode* head) {
        if(head == NULL) return head;
        ListNode* newHead = NULL, *tail = NULL, *curr = head;

        while(curr != NULL){
            int val = find(curr->next);
            if(newHead == NULL){
                newHead = new ListNode(val);
                tail = newHead;
            }
            else if(val != 0){
                tail->next = new ListNode(val);
                tail = tail->next;
            }
            curr = curr->next;
        }
        return newHead;
    }
};