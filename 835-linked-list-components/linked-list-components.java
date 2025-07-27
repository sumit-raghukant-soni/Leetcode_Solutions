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
    public int numComponents(ListNode head, int[] nums) {
        int sz = nums.length, cnt = 0, ans = 0;
        int component[] = null;
        boolean flg = false;
        List<Integer> values = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            cnt++;
            values.add(curr.val);
            curr = curr.next;
        }
        component = new int[cnt];
        // System.out.println(cnt);

        for(int i=0; i<sz; i++){
            component[nums[i]]++;
        }

        for(int i=0; i<cnt; i++){
            flg = false;
            while(i < cnt && component[values.get(i)] == 1){
                i++;
                flg = true;
            }
            if(flg) ans++;
        }

        return ans;
    }
}