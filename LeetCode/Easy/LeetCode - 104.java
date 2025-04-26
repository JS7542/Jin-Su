class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 빈 노드의 깊이는 0이다.
     * 왼쪽과 오른쪽 부분 트리 깊이 중 큰 값에 현재 노드 1을 더한다.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
