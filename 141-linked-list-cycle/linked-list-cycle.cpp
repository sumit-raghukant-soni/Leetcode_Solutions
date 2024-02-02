class Solution {
public:
    bool hasCycle(ListNode *head) {
        unordered_map<ListNode*, int> mp;
        while(head != NULL){
            if(mp.find(head) != mp.end()) return true;
            mp[head]++;
            head = head->next;
        } 
        return false;
    }
};