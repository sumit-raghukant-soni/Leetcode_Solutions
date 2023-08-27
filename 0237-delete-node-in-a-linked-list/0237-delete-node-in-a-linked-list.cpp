class Solution {
public:
    void deleteNode(ListNode* &node) {
        if(node->next == NULL){
            node = NULL;
            return;
        }
        if(node && node->next){
            node->val = node->next->val;
            deleteNode(node->next);
        }
    }
};