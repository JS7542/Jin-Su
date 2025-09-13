class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 느린 포인터로 리스트 중간을 찾고 뒷부분을 뒤집는다.
     * 앞부분과 뒤집힌 뒷부분 노드를 번갈아 연결한다.
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;
        ListNode first = head;

        while (second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;

            first.next = second;
            second.next = nextFirst;

            first = nextFirst;
            second = nextSecond;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }
}
