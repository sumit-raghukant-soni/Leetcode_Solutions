class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        set<pair<int, int>> mp;

        queue<TreeNode*> q;
        q.push(root);
        q.push(NULL);
        int tmp = 0, level = 1;
        while(!q.empty()){
            TreeNode* front = q.front();
            q.pop();
            if(front == NULL){
                mp.insert({level++, tmp});
                tmp = 0;
                if(q.empty()) break;
                else{
                    front = q.front();
                    q.pop();
                    q.push(NULL);
                }
            }
            tmp += front->val;
            if(front->left) q.push(front->left);
            if(front->right) q.push(front->right);
        }

        int ans = 1;
        tmp = INT_MIN;
        for(auto i = mp.begin(); i != mp.end(); i++){
            if(i->second > tmp){ tmp = i->second, ans = i->first; }
            else if(i->second == tmp) ans = min(i->first, ans);
        }   
        return ans;
    }
};