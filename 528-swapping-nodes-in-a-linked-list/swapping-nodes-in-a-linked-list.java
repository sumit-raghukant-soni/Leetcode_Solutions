/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int sz = 0, val1, val2, up = 0, down = 0;
    public ListNode swapNodes(ListNode head, int k) {
        sz = calcSize(head);
        solve(head, k);

        return head;
    }

    private int calcSize(ListNode head){
        if(head == null) return 0;
        return 1 + calcSize(head.next);
    }

    private void solve(ListNode head, int k){
        if(head == null) return;

        if(up == k-1){
            val1 = head.val;
        }
        if(sz-k == up){
            val2 = head.val;
        }
        up++;
        solve(head.next, k);
        down++;
        if(down == k){
            // val2 = head.val;
            head.val = val1;
        }
        if(sz - (k-1) == down){
            head.val = val2;
        }
        // System.out.println(val1 + " " + val2);
    }
}