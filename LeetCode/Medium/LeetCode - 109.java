class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /*
     * 연결 리스트 길이를 구하고 중위 순회 순서로 균형 이진 탐색 트리를 만든다.
     * 왼쪽 서브트리를 만든 뒤 현재 리스트 노드를 루트로 사용하고 오른쪽을 생성한다.
     */
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;

        for (ListNode node = head; node != null; node = node.next) length++;

        current = head;
        return build(0, length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int middle = (left + right) / 2;
        TreeNode leftTree = build(left, middle - 1);

        TreeNode root = new TreeNode(current.val);
        current = current.next;

        root.left = leftTree;
        root.right = build(middle + 1, right);

        return root;
    }
}
