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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = new ListNode();
        ListNode res = curr;
        int sum = 0;
        while(head != null){
            if(head.val == 0){
                sum = 0;
                head = head.next;
            }else{
                while(head.val != 0){
                    sum = sum+head.val;
                    head = head.next;
                }
                ListNode newNode = new ListNode(sum);
                curr.next = newNode;
                curr = newNode;
            }
        }
        return res.next;
    }
}