class Solution {
public:
    void solve(TreeNode* root, int& cnt, vector<int>& mp){
        if(root == NULL) return;
        mp[root->val]++;
        if(root->left == NULL && root->right == NULL){
            int odd = 0;
            for(int i=1; i<10; i++){
                if(mp[i] > 0){
                    if((mp[i]%2) == 1) odd++;
                }
                // cout << mp[i] << " ";
            }
            // cout << endl;
            if(odd <= 1) cnt++;
            mp[root->val]--;
            return;
        }
        // cout << "updated " << root->val << endl;
        solve(root->left, cnt, mp);
        solve(root->right, cnt, mp);
        mp[root->val]--;
    }
    int pseudoPalindromicPaths (TreeNode* root) {
        int cnt = 0;
        vector<int> mp(10, 0);

        solve(root, cnt, mp);

        return cnt;        
    }
};