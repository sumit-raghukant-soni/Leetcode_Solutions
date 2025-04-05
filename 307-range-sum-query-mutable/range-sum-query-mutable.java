class NumArray {
    private int arr[], sz;
    private TreeNode root;
    public NumArray(int[] nums) {
        sz = nums.length;
        arr = new int[sz];
        for(int i=0; i<sz; i++) arr[i] = nums[i];
        root = createTree(nums, 0, sz-1);

        // print();
    }
    
    public void update(int index, int val) {
        // System.out.println("update func " + index + ":" + val);
        int diff = val - arr[index];
        arr[index] = val;
        updateTree(root, diff, index, 0, sz-1);
        // print();
    }
    
    public int sumRange(int left, int right) {
        int ans = getSum(root, 0, sz-1, left, right);
        return ans;
    }

    private int getSum(TreeNode root, int s, int e, int left, int right){
        // System.out.println("finding " + left + " to " + right + " at " + s + ":" + e);
        if(s > e) return 0;
        
        int mid = s + (e-s)/2;
        if(s == left && e == right) return root.val;
        if(right <= mid) return getSum(root.left, s, mid, left, right);
        if(left > mid) return getSum(root.right, mid+1, e, left, right);

        return getSum(root.left, s, mid, left, mid) + getSum(root.right, mid+1, e, mid+1, right);
    }

    private void updateTree(TreeNode root, int diff, int index, int s, int e){
        // System.out.println("update " + index + " = " + s + ":" + e);
        root.val += diff;
        if(s == e){
            return;
        }

        int mid = s + (e-s)/2;
        if(index <= mid) updateTree(root.left, diff, index, s, mid);
        else updateTree(root.right, diff, index, mid+1, e);
    }

    private TreeNode createTree(int nums[], int s, int e){
        TreeNode root = new TreeNode(0);
        if(s == e){
            root.val = nums[s];
        }
        else {
            int mid = s + (e-s)/2;
            root.left = createTree(nums, s, mid);
            root.right = createTree(nums, mid+1, e);
            root.val = root.left.val + root.right.val;
        }
        return root;
    }


    private void print(){
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()) break;
                curr = q.poll();
                q.add(null);
            }
            System.out.print(curr.val + ", ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int v){
        this.val = v;
        left = null; right = null;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */