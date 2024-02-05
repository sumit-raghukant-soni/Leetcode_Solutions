class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1 == NULL) return list2;
        if(list2 == NULL) return list1;

        ListNode *ansHead = NULL, *ansTail = NULL, *a = list1, *b = list2;        

        while(a != NULL || b != NULL){
            int v1 = a ? a->val : INT_MAX;
            int v2 = b ? b->val : INT_MAX;
            if(v1 <= v2){
                if(ansTail == NULL) ansTail = a;
                else{
                    ansTail->next = a;
                    ansTail = ansTail->next;
                }
                a = a->next;
            }
            else{
                if(ansTail == NULL) ansTail = b;
                else{
                    ansTail->next = b;
                    ansTail = ansTail->next;
                }
                b = b->next;
            }
            if(ansHead == NULL) ansHead = ansTail;
            ansTail->next = NULL;
        }

        return ansHead;
    }
};