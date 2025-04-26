class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 루트의 왼쪽과 오른쪽 부분 트리를 거울 관계로 비교한다.
     * 바깥쪽 자식끼리와 안쪽 자식끼리를 재귀적으로 확인한다.
     */
    public boolean isSymmetric(TreeNode root) {
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;

        return mirror(left.left, right.right)
                && mirror(left.right, right.left);
    }
}
