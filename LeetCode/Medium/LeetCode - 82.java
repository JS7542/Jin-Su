class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 더미 노드 뒤에서 중복 구간의 시작과 끝을 찾는다.
     * 같은 값이 반복되면 전체 구간을 건너뛰고, 아니면 포인터를 한 칸 이동한다.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        while (previous.next != null) {
            ListNode current = previous.next;

            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }

            if (previous.next != current) previous.next = current.next;
            else previous = previous.next;
        }

        return dummy.next;
    }
}
