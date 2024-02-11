class Solution {
public:
    TreeNode* addNode(vector<int>& nums, int s, int e){
        // cout << s << " " << e << endl;
        if(s > e) return NULL;

        int mid = s + (e-s)/2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = addNode(nums, s, mid-1);
        root->right = addNode(nums, mid+1, e);

        return root;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int sz = nums.size();
        int mid = sz/2;

        TreeNode* root = new TreeNode(nums[mid]);
        root->left = addNode(nums, 0, mid-1);
        root->right = addNode(nums, mid+1, sz-1);

        return root;        
    }
};