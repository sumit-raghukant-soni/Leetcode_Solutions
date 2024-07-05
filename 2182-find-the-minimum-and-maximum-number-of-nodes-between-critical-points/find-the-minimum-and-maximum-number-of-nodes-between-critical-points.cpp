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
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        int prev = -1, i=0, minDistance = INT_MAX, maxDistance = -1, sz = 0;
        ListNode* curr = head;
        vector<int> criticalPoints;

        while(curr){
            if(!curr->next) break;
            
            if((prev != -1 && prev < curr->val && curr->next->val < curr->val) || (prev > curr->val && curr->next->val > curr->val)) {
                criticalPoints.push_back(i);
            }

            i++;
            prev = curr->val;
            curr = curr->next;
        }

        sz = criticalPoints.size();
        for(int i=0; i<sz-1; i++){
            if(criticalPoints[i+1]-criticalPoints[i] < minDistance){
                minDistance = criticalPoints[i+1] - criticalPoints[i];
            }
        }

        if(sz > 1) maxDistance = criticalPoints[sz-1] - criticalPoints[0];

        return {(minDistance == INT_MAX ? -1 : minDistance), maxDistance};
    }
};