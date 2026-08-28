class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for two partitions
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        // Traverse the original list
        while (head != null) {

            if (head.val < x) {
                // Add node to less list
                less.next = head;
                less = less.next;
            } else {
                // Add node to greater/equal list
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // Connect both partitions
        less.next = greaterDummy.next;

        // Very important: terminate the final list
        greater.next = null;

        return lessDummy.next;
    }
}