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

// Approach 1(Worst) but as per follow up given, then we need 
// Reservoir Sampling algorithm to solve efficiently.
/**
class Solution {

    List<Integer> list;

    public Solution(ListNode head) {

        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int n = list.size();
        return list.get((int)(Math.random()%n));
    }
}
**/

class Solution {

    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {

        ListNode curr = head;

        int result = curr.val;
        int i = 1;

        while (curr != null) {

            // Pick current node with probability 1/i
            if (Math.random() < 1.0 / i) {
                result = curr.val;
            }

            curr = curr.next;
            i++;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */