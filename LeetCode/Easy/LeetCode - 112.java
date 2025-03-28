class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 현재 노드 값을 목표 합에서 뺀 뒤 자식으로 내려간다.
     * 리프 노드에서 남은 목표가 현재 값과 같으면 경로가 존재한다.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
    }
}
