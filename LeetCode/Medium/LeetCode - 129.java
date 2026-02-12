class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 부모까지 만든 수에 10을 곱하고 현재 노드 값을 더한다.
     * 리프 노드에서 완성된 수를 반환하고 양쪽 결과를 합산한다.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int value) {
        if (node == null) return 0;

        int current = value * 10 + node.val;

        if (node.left == null && node.right == null) return current;

        return dfs(node.left, current) + dfs(node.right, current);
    }
}
