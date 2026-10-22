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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        ListNode res = new ListNode();
        int n = 1;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            int val = stack.pop();
            max = Math.max(max, val);

            if(val>=max){
                ListNode newNode = new ListNode(val);
                if(n==1){
                    res = newNode;
                    n++;
                }else{
                    newNode.next = res;
                    res = newNode;
                }
            }
        }
        return res;
    }
}