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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        int sz = 0;
        vector<ListNode*> ans(k, NULL);
        if(!head) return ans;
        ListNode *curr = head, *next = NULL;

        while(curr){
            curr = curr->next;
            sz++;
        }

        int eachPart = sz/k, extra = sz%k;

        cout << eachPart << " " << extra << endl;

        curr = head;
        for(int i=0; i<k; i++){
            if(!curr) break;
            ListNode* element = curr, *tail = curr;
            for(int j=0; j<(eachPart + (extra > 0 ? 1 : 0)) && curr; j++){
                tail = curr;
                curr = curr->next;
            }
            extra--;
            tail->next = NULL;
            ans[i] = element;
        }

        return ans;
    }
};