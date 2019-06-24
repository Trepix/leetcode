/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return _addTwoNumbers(l1, l2, 0);
    }
    
    private ListNode _addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) return null;
            return new ListNode(1);
        }
        
        int val = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
        ListNode next = _addTwoNumbers(l1 == null ? null : l1.next , l2 == null ? null : l2.next, val / 10);
        
        ListNode node = new ListNode(val%10);
        node.next = next;
        return node;
    }
    
}