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
     * 각 노드에서 현재 노드를 털지 않는 최대값과 터는 최대값을 함께 계산한다.
     * 현재 노드를 털면 두 자식은 털 수 없고, 털지 않으면 자식별 최댓값을 선택한다.
     */
    public int rob(TreeNode root) {
        int[] result = search(root);
        return Math.max(result[0], result[1]);
    }

    private int[] search(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = search(node.left);
        int[] right = search(node.right);

        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int take = node.val + left[0] + right[0];

        return new int[]{skip, take};
    }
}
