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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode large = new ListNode();
        ListNode smallP = small;
        ListNode largeP = large;
        while(head != null){
            ListNode node = new ListNode(head.val);
            if(head.val < x){
                smallP.next = node;
                smallP = smallP.next;
            }else{
                largeP.next = node;
                largeP = largeP.next;
            }
            head = head.next;
        }
        smallP.next = large.next;
        return small.next;
    }
}