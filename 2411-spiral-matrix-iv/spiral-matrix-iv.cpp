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
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> ans(m, vector<int>(n, -1));

        int sr = 0, sc = 0, er = m-1, ec = n-1;
        ListNode* curr = head;

        while(curr){
            for(int i=sc; i<=ec && curr; i++){
                ans[sr][i] = curr->val;
                curr = curr->next;
            }
            sr++;
            for(int i=sr; i<=er && curr; i++){
                ans[i][ec] = curr->val;
                curr = curr->next;
            }
            ec--;
            for(int i=ec; i>=sc && curr; i--){
                ans[er][i] = curr->val;
                curr = curr->next;
            }
            er--;
            for(int i=er; i>=sr && curr; i--){
                ans[i][sc] = curr->val;
                curr = curr->next;
            }
            sc++;
        }

        return ans;
    }
};