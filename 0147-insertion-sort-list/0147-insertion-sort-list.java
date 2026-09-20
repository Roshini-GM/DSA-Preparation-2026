class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            ListNode curr = dummy;
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            head.next = curr.next;
            curr.next = head;
            head = next;
        }
        return dummy.next;
    }
}