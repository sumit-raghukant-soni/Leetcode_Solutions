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
                sz++;
                if(sz > 1){
                    if(criticalPoints[sz-1]-criticalPoints[sz-2] < minDistance){
                        minDistance = criticalPoints[sz-1] - criticalPoints[sz-2];
                    }
                    maxDistance = criticalPoints[sz-1] - criticalPoints[0];
                }
            }

            i++;
            prev = curr->val;
            curr = curr->next;
        }

        return {(minDistance == INT_MAX ? -1 : minDistance), maxDistance};
    }
};