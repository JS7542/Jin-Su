class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 왼쪽 끝 높이와 오른쪽 끝 높이가 같으면 완전한 포화 트리다.
     * 다르면 왼쪽과 오른쪽 서브트리 노드 수를 재귀적으로 더한다.
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root;
        TreeNode right = root;

        while (left != null) {
            leftHeight++;
            left = left.left;
        }

        while (right != null) {
            rightHeight++;
            right = right.right;
        }

        if (leftHeight == rightHeight) return (1 << leftHeight) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
