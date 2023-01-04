/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode second = head.next;
        int removedPosition = _removeNthFromEnd(head, n);
        if (removedPosition == n) return second;
        return head;
    }

    public Integer _removeNthFromEnd(ListNode node, int n) {
        if (node == null) return 0;
        int position = _removeNthFromEnd(node.next, n);
        if (position == n) {
            node.next = node.next.next;
        }
        return position + 1;
    }
}