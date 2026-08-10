import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min Heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of every list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node to build the answer
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the smallest node
        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            current.next = node;
            current = current.next;

            // Add the next node from the same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}