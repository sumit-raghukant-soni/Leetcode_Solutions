/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> arr = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int sz = queries.size(), sz2;
        List<List<Integer>> ans = new ArrayList<>();

        populateArr(root);
        sz2 = arr.size();

        for(int i=0; i<sz; i++){
            List<Integer> tmp = new ArrayList<>();
            
            int ind = getMinIndex(queries.get(i));
            // System.out.println("getMinIndex " + ind);
            tmp.add(ind == -1 ? -1 : arr.get(ind));
            // if(ind != -1 && ind+1 < sz) tmp.add(arr.get(ind+1));
            // else if(arr.get(0) >= queries.get(i)) tmp.add(arr.get(0));
            // else tmp.add(-1);

            if(ind != -1 && arr.get(ind) >= queries.get(i)) tmp.add(arr.get(ind));
            else if(ind != -1 && ind+1 < sz2) tmp.add(arr.get(ind+1));
            else if(ind == -1 && arr.get(0) >= queries.get(i)) tmp.add(arr.get(0));
            else tmp.add(-1);

            ans.add(tmp);
        }

        return ans;
    }

    private void populateArr(TreeNode root){
        if(root == null) return;

        populateArr(root.left);
        arr.add(root.val);
        populateArr(root.right);
    }

    private int getMinIndex(int val){
        int s = 0, e = arr.size()-1, ans = -1;

        while(s <= e){
            int mid = s + (e-s)/2;
            // System.out.println("for " + val + " " + arr.get(mid));
            if(arr.get(mid) <= val){
                if(mid > ans) ans = mid;
                s = mid+1;
            }
            else e = mid-1; 
            // System.out.println("indexes " + s + " " + e);
        }
        // System.out.println();

        return ans;
    }
}