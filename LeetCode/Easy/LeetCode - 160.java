class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    /*
     * 두 포인터가 각 리스트 끝에 도달하면 다른 리스트의 시작으로 이동한다.
     * 전체 이동 길이가 같아져 교차 노드 또는 null에서 만나게 된다.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;

        while (first != second) {
            first = first == null ? headB : first.next;
            second = second == null ? headA : second.next;
        }

        return first;
    }
}
