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
    int sz = 0, up = 0, down = 0;
    ListNode first = null, second = null;
    public ListNode swapNodes(ListNode head, int k) {
        solve(head, k);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }

    private void solve(ListNode head, int k){
        if(head == null) return;

        if(up == k-1) first = head;
        
        sz++;
        up++;
        solve(head.next, k);
        down++;
        
        if(k == down) second = head;
    }
}