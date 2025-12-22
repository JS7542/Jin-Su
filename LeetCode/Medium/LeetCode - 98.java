class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 각 노드가 가질 수 있는 값의 최소·최대 범위를 전달한다.
     * 현재 값이 범위를 벗어나면 false, 아니면 두 자식 범위를 좁혀 재귀 검사한다.
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long minimum, long maximum) {
        if (node == null) return true;
        if (node.val <= minimum || node.val >= maximum) return false;

        return valid(node.left, minimum, node.val)
                && valid(node.right, node.val, maximum);
    }
}
