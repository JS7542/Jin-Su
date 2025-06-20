class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 더미 노드에서 left 직전 노드까지 이동한다.
     * 구간 안의 다음 노드를 반복해서 구간 앞쪽으로 옮긴다.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;

        for (int i = 1; i < left; i++) before = before.next;

        ListNode current = before.next;

        for (int i = 0; i < right - left; i++) {
            ListNode moved = current.next;
            current.next = moved.next;
            moved.next = before.next;
            before.next = moved;
        }

        return dummy.next;
    }
}
