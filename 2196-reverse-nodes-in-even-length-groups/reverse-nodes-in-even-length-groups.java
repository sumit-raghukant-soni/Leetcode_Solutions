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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int sz = 0, len = 1, k = 1;
        ListNode curr = head, next = null;
        while(curr != null){
            sz++; curr = curr.next;
        }
        if(sz <= 1) return head;
        
        curr = head;
        while(curr != null && curr.next != null && k < sz){
            len++;
            boolean NeedToReverse = (((sz-k) >= len && (len%2) == 0) || (len > (sz-k) && ((sz-k)%2) == 0));
            // System.out.println("curr: " + curr.val + " " + NeedToReverse);
            if(NeedToReverse){
                next = curr;
                // System.out.println("Size " + (len));
                for(int i=0; i<=(sz-k) && i<=len; i++){
                    next = next.next;
                }
                curr.next = reverse(curr.next, curr, len);
            }

            for(int i=0; i<len && curr != null; i++){
                curr = curr.next; k++;
            }

            if(curr != null && NeedToReverse) curr.next = next;
        }

        return head;
    }

    private ListNode reverse(ListNode head, ListNode p, int sz){
        ListNode curr = head, next = null, prev = null;
        while(curr != null && sz > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            sz--;
        }

        // curr = prev;
        // while(curr != null){
        //     System.out.println(curr.val);
        //     curr = curr.next;
        // }

        return prev;
    }
}