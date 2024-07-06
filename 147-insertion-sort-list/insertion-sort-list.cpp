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
    void insert(stack<ListNode*>& st, ListNode* curr){
        if(st.empty() || st.top()->val > curr->val){
            st.push(curr);
            return;
        }

        ListNode* out = st.top();
        st.pop();
        insert(st, curr);
        st.push(out);

    }
    ListNode* insertionSortList(ListNode* head) {
        ListNode *curr = head, *next = NULL, *ansHead = NULL, *tail = NULL;
        stack<ListNode*> st;

        while(curr){
            next = curr->next;
            curr->next = NULL;
            insert(st, curr);
            curr = next;
        }

        while(!st.empty()){
            ListNode* tmp = st.top();
            st.pop();
            if(!ansHead){
                ansHead = tmp;
                tail = ansHead;
            }
            else{
                tail->next = tmp;
                tail = tail->next;
            }
        }

        return ansHead;
    }
};