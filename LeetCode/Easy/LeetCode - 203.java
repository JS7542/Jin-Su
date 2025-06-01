class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 더미 노드를 리스트 앞에 두어 첫 노드 삭제도 동일하게 처리한다.
     * 다음 노드 값이 val이면 건너뛰고 아니면 현재 포인터를 이동한다.
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) current.next = current.next.next;
            else current = current.next;
        }

        return dummy.next;
    }
}
