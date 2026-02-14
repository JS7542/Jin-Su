class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 느린 포인터로 리스트를 절반으로 나누고 각 절반을 재귀적으로 정렬한다.
     * 정렬된 두 리스트를 병합 정렬 방식으로 합친다.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(second));
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        current.next = first != null ? first : second;
        return dummy.next;
    }
}
