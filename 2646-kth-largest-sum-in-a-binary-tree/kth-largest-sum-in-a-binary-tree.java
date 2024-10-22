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

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        long sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<Long, Integer> s = new TreeMap<>((key1, key2) -> {
            return Long.compare(key2, key1);
        });
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.peek();
            q.remove(curr);
            if (curr == null) {
                System.out.println(sum);
                if(s.containsKey(sum)){
                    s.put(sum, s.get(sum) + 1);
                } 
                else s.put(sum, 1);
                sum = 0;
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
                curr = q.peek();
                q.remove(curr);
            }
            sum += curr.val;
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }

        for (Map.Entry<Long, Integer> pair : s.entrySet()) {
            k -= pair.getValue();
            if(k <= 0) return pair.getKey();
        }

        return -1;
    }
}