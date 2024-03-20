class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode *curr = list1, *aprev = NULL, *bprev = NULL;
        int n = 0;

        while(curr && n < a){
            aprev = curr;
            curr = curr->next;
            n++;
        }
        
        while(curr && n <= b){
            bprev = curr;
            curr = curr->next;
            n++;
        }

        aprev->next = list2;
        
        while(list2->next) list2 = list2->next;
        list2->next = bprev->next;

        return list1;
    }
};