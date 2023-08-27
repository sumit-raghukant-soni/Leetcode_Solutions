class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode *curr = list1, *a1=NULL, *b1=list2;
        int i = 0;
        while(b1->next != NULL) b1 = b1->next;
        while(i != b+1 && curr){
            if(i == a-1)
                a1 = curr;
            if(i == b){
                b1->next = curr->next;
                curr->next = NULL;
            }
            curr = curr->next;
            i++;
        }
        a1->next = list2;
        return list1;
    }
};