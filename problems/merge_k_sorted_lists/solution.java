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
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.stream;
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode current = head;
        ArrayList<ListNode> list = new ArrayList<>();
        for (ListNode l : lists) {
            if (l != null) list.add(l);
        }

        if (list.size() == 1) return list.get(0);

        while (!list.isEmpty()) {
            int min_position = -1;
            for (int i = 0; i < list.size(); i++) {
                if (min_position == -1) min_position = i;
                else if (list.get(i).val < list.get(min_position).val) min_position = i;
            }
            current.next = list.get(min_position);
            current = current.next;
            ListNode nextNode = list.get(min_position).next;
            if (nextNode == null) list.remove(min_position);
            else list.set(min_position, nextNode);
        }
        return head.next;
    }
}