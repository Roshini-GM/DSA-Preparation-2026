class Solution {
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    public int getRandom() {
        ListNode curr = head;
        int result = 0;
        int count = 1;
        while (curr != null) {
            if (Math.random() < 1.0 / count) {
                result = curr.val;
            }
            curr = curr.next;
            count++;
        }
        return result;
    }
}