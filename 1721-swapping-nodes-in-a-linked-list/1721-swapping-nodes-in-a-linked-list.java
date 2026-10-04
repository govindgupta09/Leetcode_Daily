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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode temp = head;
        for(int i=1;i<k;i++){
            end = end.next;
            temp = temp.next;
        }
        while(end.next != null && end != null){
            start = start.next;
            end = end.next;
        }
        int value = temp.val;
        temp.val = start.val;
        start.val = value;

        return head;
    }
}