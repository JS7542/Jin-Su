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
     * 느린 포인터는 한 칸, 빠른 포인터는 두 칸씩 이동한다.
     * 사이클이 있으면 두 포인터가 언젠가 같은 노드에서 만난다.
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
