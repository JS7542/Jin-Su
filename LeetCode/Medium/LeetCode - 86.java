class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

class Solution {
    /*
     * x보다 작은 노드와 나머지 노드를 두 개의 리스트에 순서대로 연결한다.
     * 작은 값 리스트 뒤에 큰 값 리스트를 붙여 안정적인 분할을 완성한다.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode();
        ListNode largeDummy = new ListNode();
        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = largeDummy.next;
        return smallDummy.next;
    }
}
