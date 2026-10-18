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
    public static ListNode reverse(ListNode head){
        ListNode newNode = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode curr = head;
        ListNode slow = curr;
        ListNode fast = curr;
        ListNode prev = new ListNode();
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode end = reverse(slow);
        while(head != null){
            ListNode temp = head.next;
            ListNode etemp = end.next;
            head.next = null;
            if(temp != null){
                end.next = null;
                end.next = temp;
            }
            head.next = end;
            head = temp;
            if(temp != null){
                end = etemp;
            }
        }
    }
}