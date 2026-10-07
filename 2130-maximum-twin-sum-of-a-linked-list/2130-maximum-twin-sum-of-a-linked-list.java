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
    public int pairSum(ListNode head) {
        int sum=0;
        ListNode slow = head, fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = reverse(slow);
        ListNode temp1 = head, temp2 = revHead;
        int ans = 0;
        while(temp2 != null){
            ans  = Math.max(ans, temp1.val+temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return ans;
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}