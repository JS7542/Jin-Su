class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    /*
     * 현재 노드에 왼쪽 서브트리가 있으면 그 서브트리의 가장 오른쪽 노드를 찾는다.
     * 기존 오른쪽 서브트리를 연결한 뒤 왼쪽 서브트리를 오른쪽으로 옮긴다.
     */
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode predecessor = current.left;

                while (predecessor.right != null) predecessor = predecessor.right;

                predecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }
}
