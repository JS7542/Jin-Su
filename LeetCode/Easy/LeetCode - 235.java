class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    /*
     * 두 값이 현재 노드보다 모두 작으면 왼쪽으로 이동한다.
     * 모두 크면 오른쪽으로 이동하고, 갈라지는 현재 노드가 최소 공통 조상이다.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }

        return null;
    }
}
