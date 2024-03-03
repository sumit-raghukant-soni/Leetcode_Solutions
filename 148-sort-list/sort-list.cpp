class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if(!head) return head;
        vector<ListNode*> tmp;
        ListNode* curr = head;
        while(curr){
            tmp.push_back(curr);
            curr = curr->next;
        }
        sort(tmp.begin(), tmp.end(), [&](ListNode* a, ListNode* b){
            return a->val < b->val;
        });

        head = tmp[0];
        curr = head;
        curr->next = NULL;
        for(int i=1; i<tmp.size(); i++){
            curr->next = tmp[i];
            curr = curr->next;
            curr->next = NULL;
        }

        return head;
    }
};