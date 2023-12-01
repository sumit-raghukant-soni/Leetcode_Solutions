class Solution {
public:
    int checkSum(TreeNode* root, map<int, int>& mp){
        if(root == NULL) return 0;
        if(root->left == NULL && root->right == NULL){
            mp[root->val]++;
            return root->val;
        }
        int left = checkSum(root->left, mp);
        int right = checkSum(root->right, mp);
        mp[root->val + left + right]++;
        return root->val + left + right;
    }
    vector<int> findFrequentTreeSum(TreeNode* root) {
        map<int, int> mp;
        checkSum(root, mp);

        int maxCnt = 0;
        for(auto i : mp)
            maxCnt = max(maxCnt, i.second);

        vector<int> ans;
        for(auto i : mp)
            if(i.second == maxCnt) ans.push_back(i.first);

        return ans;
    }
};