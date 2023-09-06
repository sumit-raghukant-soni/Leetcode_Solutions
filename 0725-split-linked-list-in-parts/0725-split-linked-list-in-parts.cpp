class Solution {
public:
    int findSZ(ListNode* head){
        int cnt = 0;
        while(head != NULL){
            cnt++;
            head = head->next;
        }
        return cnt;
    }
    vector<ListNode*> individuals(ListNode* head, int k){
        vector<ListNode*> ans;
        ListNode* tmp;
        int i = 0;
        while(head != NULL || i < k){
            if(head != NULL){
                tmp = head;
                head = head->next;
                tmp->next = NULL;
                ans.push_back(tmp);
            }
            else ans.push_back(NULL);
            i++;
        }
        return ans;
    }
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        int sz = findSZ(head);
        if(sz <= k)
            return individuals(head, k);

        int splitsz = sz/k, extra = sz%k;
        vector<ListNode*> ans;
        ListNode* curr = head, *prev = NULL;
        for(int i=0; i<k; i++){
            ans.push_back(curr);
            if(extra){
                curr = curr->next;
                extra--;
            }
            for(int j=0; j<splitsz; j++){
                prev = curr;
                curr = curr->next;
            }
            prev->next = NULL;
        }
        return ans;
    }
};