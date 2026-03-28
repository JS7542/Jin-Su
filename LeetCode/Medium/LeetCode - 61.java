class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 리스트 길이를 구하고 마지막 노드를 머리에 연결해 원형으로 만든다.
     * 새 꼬리 위치까지 이동한 뒤 연결을 끊어 오른쪽 회전을 완성한다.
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;
        if (k == 0) return head;

        tail.next = head;
        int steps = length - k;
        ListNode newTail = tail;

        while (steps-- > 0) newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
