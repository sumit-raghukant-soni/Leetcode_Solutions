class Solution {
public:
    void merge2List(ListNode* &a, ListNode* b) {
        ListNode *tmp = new ListNode(-1), *tail = tmp;

        while (a || b) {
            int v1 = a ? a->val : INT_MAX, v2 = b ? b->val : INT_MAX;
            if (v1 < v2) {
                // cout << v1 << endl;
                tail->next = a;
                a = a->next;
            } else {
                // cout << v2 << endl;
                tail->next = b;
                b = b->next;
            }
            tail = tail->next;
        }
        a = tmp->next;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.size() == 0)
            return NULL;

        ListNode* ans = NULL;
        int sz = lists.size();

        for (int i = 0; i < sz; i++) {
            if (i == 0)
                ans = lists[i];
            else
                merge2List(ans, lists[i]);
            // ListNode* curr = ans;
            // while (curr) {
            //     cout << curr->val << " ";
            //     curr = curr->next;
            // }
            // cout << endl;
        }

        return ans;
    }
};