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
    public ListNode doubleIt(ListNode head) {
        ListNode end = reverse(head);
        ListNode res = null;
        int carry = 0;
        while(end != null){
            int val = end.val*2 + carry;
            int unit = val%10;
            carry = val/10;
            ListNode newNode = new ListNode(unit);
            newNode.next = res;
            res = newNode;
            end = end.next;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            node.next = res;
            res = node;
        }
        return res;
    }
}