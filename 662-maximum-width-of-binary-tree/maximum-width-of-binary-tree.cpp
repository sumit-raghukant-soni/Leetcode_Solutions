class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        unsigned long long ans = 0;
        unordered_map<int, unsigned long long> minimp, maximp;
        queue<pair<TreeNode*, pair<long, long>>> q;
        
        q.push({root, {0, 0}});

        while(!q.empty()){
            auto front = q.front();
            q.pop();
            int level = front.second.first;
            unsigned long long ind = front.second.second;
            if(minimp.find(level) == minimp.end()) minimp[level] = ind;
            else minimp[level] = min(minimp[level], ind);
            if(maximp.find(level) == maximp.end()) maximp[level] = ind;
            else maximp[level] = max(maximp[level], ind);
            
            if(front.first->left){
                q.push({front.first->left, {level+1, (ind*2)+1}});
            }
            if(front.first->right){
                q.push({front.first->right, {level+1, (ind*2)+2}});
            }
        }  

        for(int i=0; i<minimp.size(); i++){
            ans = max(ans, (maximp[i] - minimp[i] + 1));
        }

        return ans;
    }
};