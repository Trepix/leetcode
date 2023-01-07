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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        for (int i = 0; i < k; i++, tmp = tmp.next) {
            if (tmp == null) return head;
        }

        ListNode newHead = reverse(head, k);
        head.next = reverseKGroup(tmp, k);
        return newHead;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode tmp = head.next;
        if (k == 1) return head;
        ListNode tail = reverse(head.next, --k);
        tmp.next = head;
        return tail;
    }
}