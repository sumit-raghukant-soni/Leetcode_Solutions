class Solution {
public:
    int pairSum(ListNode* head) {
        ios_base::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL);
       unordered_map<int, int> mp;
       int sz = 0, cnt = 0;
       ListNode* curr = head;
       while(curr){
           curr = curr->next;
           sz++;
       } 
       curr = head;
       int maxi = INT_MIN;
       while(curr){
           if(cnt < sz/2)
               mp[cnt] = curr->val;
           else{
               mp[(sz/2) - (cnt - (sz/2) + 1)] += curr->val;
               maxi = max(maxi, mp[(sz/2) - (cnt - (sz/2) + 1)]);
           }
           curr = curr->next;
           cnt++;
       }
        return maxi;
    }
};