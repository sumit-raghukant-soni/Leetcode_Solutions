class Solution {
public:
    ListNode* removeZeroSumSublists(ListNode* head) {
        if(!head) return head;
        ListNode *front = head, *curr = head, *prev = new ListNode(-1), *ans = prev;
        prev->next = head;
        curr = prev->next;        

        while(curr){
            ListNode* curr2 = curr;
            int sum = INT_MIN, flg = 0;
            while(curr2){
                if(sum == INT_MIN) sum = curr2->val;
                else sum += curr2->val;
                if(sum == 0){
                    // cout << sum << " " << curr->val << " " << curr2->val << endl;
                    flg = 1;
                    break;
                }
                curr2 = curr2->next;
            }
            if(flg){
                // cout << "Here" << endl;
                prev->next = curr2->next;
                curr = curr2;
            }
            else prev = curr;
            curr = curr->next;
        }

        return ans->next;
    }
};