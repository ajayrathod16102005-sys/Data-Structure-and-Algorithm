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
    public ListNode insertionSortList(ListNode head) {

        // Dummy node for the sorted list
        ListNode dummy = new ListNode(0);

        ListNode current = head;

        while (current != null) {
            // Save next node
            ListNode next = current.next;

            // Find position in sorted list
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            // Insert current node
            current.next = prev.next;
            prev.next = current;

            // Move to next input node
            current = next;
        }

        return dummy.next;
    }
}