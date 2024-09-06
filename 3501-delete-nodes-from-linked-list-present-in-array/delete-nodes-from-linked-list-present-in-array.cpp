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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_map<int, int> mp;

        for(int i : nums) mp[i]++;

        ListNode* ans = new ListNode(-1), *tail = ans, *curr = head;
        ans->next = head;

        while(curr){
            if(mp.find(curr->val) == mp.end()){
                tail->next = curr;
                tail = tail->next;   
            }
            curr = curr->next;
        }

        tail->next = NULL;

        return ans->next;
    }
};