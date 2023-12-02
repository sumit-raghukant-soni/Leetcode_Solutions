class Solution {
public:
    int pairSum(ListNode* head) {
        ios_base::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL);
       map<int, int> mp;
       int sz = 0, cnt = 0;
       ListNode* curr = head;
       while(curr){
           curr = curr->next;
           sz++;
       } 
       curr = head;
       while(curr){
           if(cnt < sz/2)
               mp[cnt] = curr->val;
           else
               mp[(sz/2) - (cnt - (sz/2) + 1)] += curr->val;
           curr = curr->next;
           cnt++;
       }
        int maxi = INT_MIN;

        for(auto i : mp) maxi = max(maxi, i.second);

        return maxi;
    }
};