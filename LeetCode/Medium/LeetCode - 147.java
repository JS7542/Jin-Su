class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 정렬된 리스트 앞에 더미 노드를 둔다.
     * 원본 노드를 하나씩 꺼내 정렬 리스트의 올바른 위치에 삽입한다.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        while (head != null) {
            ListNode next = head.next;
            ListNode position = dummy;

            while (position.next != null && position.next.val < head.val) {
                position = position.next;
            }

            head.next = position.next;
            position.next = head;
            head = next;
        }

        return dummy.next;
    }
}
