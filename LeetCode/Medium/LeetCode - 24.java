class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 더미 노드 뒤의 두 노드를 한 쌍으로 잡는다.
     * 두 노드의 연결 순서를 바꾸고 다음 쌍 앞까지 포인터를 이동한다.
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        while (previous.next != null && previous.next.next != null) {
            ListNode first = previous.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            previous.next = second;

            previous = first;
        }

        return dummy.next;
    }
}
