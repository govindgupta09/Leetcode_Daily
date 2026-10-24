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
    public static int gcd(int a, int b){
        while(a != 0){
            int temp = b%a;
            b = a;
            a = temp;
        }
        return b;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            int gcd_Val = gcd(prev.val, curr.val);
            ListNode newNode = new ListNode(gcd_Val);
            prev.next = newNode;
            newNode.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}