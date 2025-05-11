class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /*
     * 정렬 연결 리스트를 앞에서부터 순회한다.
     * 현재 값과 다음 값이 같으면 다음 노드를 건너뛰어 중복을 제거한다.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) current.next = current.next.next;
            else current = current.next;
        }

        return head;
    }
}
