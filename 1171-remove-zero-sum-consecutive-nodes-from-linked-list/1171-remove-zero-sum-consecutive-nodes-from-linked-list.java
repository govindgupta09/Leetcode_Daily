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
    public ListNode removeZeroSumSublists(ListNode head) {
        int pSum = 0;
        ListNode temp = head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        Map<ListNode, Integer> map = new HashMap<>();
        map.put(dummyNode, 0);
        while(head != null){
            pSum += head.val;
            map.put(head, pSum);
            for(Map.Entry<ListNode, Integer> entry : map.entrySet()){
                if(entry.getValue() == pSum){
                    temp = entry.getKey();
                    temp.next = head.next;
                }
            }
            head = head.next;
        }
        return dummyNode.next;
    }
}