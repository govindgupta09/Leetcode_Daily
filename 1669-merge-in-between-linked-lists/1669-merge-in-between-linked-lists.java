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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode prev = new ListNode(0);
        for(int j=0;j<a;j++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        prev.next = list2;
        while(list2 != null){
            prev = prev.next;
            list2 = list2.next;
        }
        for(int i=a;i<b;i++){
            curr = curr.next;
        }
        ListNode end = curr.next;
        curr.next = null;
        prev.next = end;
        return list1;
    }
}