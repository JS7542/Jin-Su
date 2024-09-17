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
     * 루트의 왼쪽 자식과 오른쪽 자식 값을 더한다.
     * 두 자식의 합이 루트 값과 같은지 확인한다.
     */
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
